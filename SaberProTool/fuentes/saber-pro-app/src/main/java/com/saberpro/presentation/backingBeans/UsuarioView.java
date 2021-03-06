package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ProgramaUsuarioDTO;
import com.saberpro.modelo.dto.TipoUsuarioDTO;
import com.saberpro.modelo.dto.UsuarioDTO;

import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.annotation.LazySingletonAspectInstanceFactoryDecorator;

import java.io.IOException;
import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
        
    private boolean crear = true;
    private boolean mostrarTipo = true;
    
    private InputText txtApellido;
    private InputText txtCelular;
    private InputText txtCodigo;
    private InputText txtCorreo;    
    private InputText txtIdentificacion;
    private InputText txtNombre;    
    
    private SelectOneMenu somTipoUsuario;
    private SelectOneMenu somGenero;
    private SelectOneMenu somFacultas;
    private SelectOneMenu somPrograma;
    
    private CommandButton btnSave;
    private CommandButton btnModify;   
    private CommandButton btnClear;
    
    private List<UsuarioDTO> data;
    
    private List<SelectItem> losTipoUsuarioSelectItem;
    private List<SelectItem> losFacultadSelectItem;
    private List<SelectItem> losProgramasSelectItem;
    
    private UsuarioDTO selectedUsuario;
    private ProgramaUsuarioDTO selectedUsuarioPrograma;
    
    private Usuario entity;
    private ProgramaUsuario entityPrograma;
    private Programa entityCarrera;
    private Facultad entityFacultad;
    private TipoUsuario entityTipoUsuario;
    
    private boolean showDialog;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuarioView(){
        super();        
    }    
    
    public void listener_txtId() {
		try {
			long codigo = Long.parseLong(txtCodigo.getValue().toString());
			//Usuario
			Object[] variable = {"codigo",true,codigo,"="};
			entity = businessDelegatorView.findByCriteriaInUsuario(variable,null,null).get(0);
			//ProgramaUsuario
			Object[] variable2 = {"usuario.idUsuario",true,entity.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
			entityPrograma = businessDelegatorView.findByCriteriaInProgramaUsuario(variable2,null,null).get(0);			
			//Programa	
			Object[] variable3 = {"idPrograma",true,entityPrograma.getPrograma().getIdPrograma(),"="};
			entityCarrera = businessDelegatorView.findByCriteriaInPrograma(variable3,null,null).get(0);
			//Facultad	
			Object[] variable4 = {"idFacultad",true,entityCarrera.getFacultad().getIdFacultad(),"="};
			entityFacultad = businessDelegatorView.findByCriteriaInFacultad(variable4,null,null).get(0);
			//TipoUsuario
			Object[] variable5 = {"idTipoUsuario",true,entity.getTipoUsuario().getIdTipoUsuario(),"="};
			entityTipoUsuario = businessDelegatorView.findByCriteriaInTipoUsuario(variable5,null,null).get(0);
			
		} catch (Exception e) {
			entity = null;
			entityPrograma = null;
			entityTipoUsuario = null;
			entityFacultad = null;
			log.error("Error en "+e.getMessage(),e);
		}

		if (entity == null && entityPrograma==null) {
			
			crear = true;
			setMostrarTipo(true);
			somPrograma.setDisabled(false);
			somFacultas.setDisabled(false);
			txtApellido.resetValue();
			txtCelular.resetValue();
			txtCorreo.resetValue();
			txtIdentificacion.resetValue();
			txtNombre.resetValue();
			
			somFacultas.resetValue();
			somGenero.resetValue();
			somPrograma.resetValue();
			somTipoUsuario.resetValue();

			btnSave.setDisabled(true);
			btnModify.setDisabled(true);

		} else {
			
			crear = false;			
			losProgramasSelectItem = null;	
			setMostrarTipo(true);
			somPrograma.setDisabled(false);
			somFacultas.setDisabled(false);
			
			txtNombre.setValue(entity.getNombre());
			txtApellido.setValue(entity.getApellido());
			txtCelular.setValue(entity.getCelular());
			txtCorreo.setValue(entity.getCorreo());
			txtIdentificacion.setValue(entity.getIdentificacion());		
			
			
			
			somGenero.setValue(entity.getGenero());			
			somFacultas.setValue(entityFacultad.getIdFacultad());
			somPrograma.setValue(entityCarrera.getIdPrograma());
			
			btnSave.setDisabled(true);
			btnModify.setDisabled(true);
			
			if(!entityTipoUsuario.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
				setMostrarTipo(false);
				somFacultas.setDisabled(true);
				if(entityTipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_DIRECTOR) {
					somPrograma.setDisabled(true);
				}
			}
			else {
				somTipoUsuario.setValue(entityTipoUsuario.getIdTipoUsuario());
				setMostrarTipo(true);
				somPrograma.setDisabled(false);
				somFacultas.setDisabled(false);
			}
			
		}
		action_validar();
	}
    
    public void verificar(CommandButton input) {
    	try {
    		if(FacesUtils.checkString(txtNombre)==null || FacesUtils.checkString(txtNombre).isEmpty()) 
        		input.setDisabled(true);  
    		if(FacesUtils.checkString(txtApellido)==null || FacesUtils.checkString(txtApellido).isEmpty()) 
        		input.setDisabled(true); 
    		if(FacesUtils.checkString(txtCelular)==null || FacesUtils.checkString(txtCelular).isEmpty()) 
        		input.setDisabled(true); 
    		if(FacesUtils.checkString(txtCodigo)==null || FacesUtils.checkString(txtCodigo).isEmpty()) 
        		input.setDisabled(true); 
    		if(FacesUtils.checkString(txtCorreo)==null || FacesUtils.checkString(txtCorreo).isEmpty()) 
        		input.setDisabled(true); 
    		if(FacesUtils.checkString(txtIdentificacion)==null || FacesUtils.checkString(txtIdentificacion).isEmpty()) 
        		input.setDisabled(true); 
        	if(FacesUtils.checkString(somFacultas)==null)
        		input.setDisabled(true);
        	if(FacesUtils.checkString(somGenero)==null)
        		input.setDisabled(true);
        	if(FacesUtils.checkString(somPrograma)==null)
        		input.setDisabled(true); 
        	if(FacesUtils.checkString(somTipoUsuario)==null && crear)
        		input.setDisabled(true);    
		} catch (Exception e) {
			log.error("Error validando "+e.getMessage(),e);
		}    	
    		
    }
    
    public String action_clear() {
    	entity = null;
		entityPrograma = null;
		entityTipoUsuario = null;
		entityFacultad = null;
		selectedUsuario = null;
		losProgramasSelectItem = null;		

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);

		txtCodigo.resetValue();
		txtNombre.resetValue();
		txtApellido.resetValue();
		txtCelular.resetValue();
		txtCorreo.resetValue();
		txtIdentificacion.resetValue();
		
		somFacultas.resetValue();
		somGenero.resetValue();
		somPrograma.resetValue();
		somTipoUsuario.resetValue();
		
		setMostrarTipo(true);

		return "";
	}
    
    public void action_validar() {
    	
    	if(crear) {
    		btnSave.setDisabled(false);
        	verificar(btnSave); 
    	}
    	else {
    		btnModify.setDisabled(false);
    		verificar(btnModify); 
    	}
    	   	
    }
    
    public String action_create() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {				
				
				entity = new Usuario();
				
				entity.setCodigo(Long.parseLong(FacesUtils.checkString(txtCodigo)));
				entity.setIdentificacion(Long.parseLong(FacesUtils.checkString(txtIdentificacion)));
				entity.setNombre(FacesUtils.checkString(txtNombre));
				entity.setApellido(FacesUtils.checkString(txtApellido));
				entity.setCelular(Long.parseLong(FacesUtils.checkString(txtCelular)));
				entity.setCorreo(FacesUtils.checkString(txtCorreo));
				entity.setUsuCreador(usuario.getIdUsuario());
				entity.setGenero(FacesUtils.checkString(somGenero));
				entity.setFechaCreacion(new Date());
				entity.setTipoUsuario(businessDelegatorView.getTipoUsuario((long)(FacesUtils.checkInteger(somTipoUsuario))));
				
				businessDelegatorView.saveUsuario(entity);
				
				entityPrograma = new ProgramaUsuario();
				
				entityPrograma.setActivo(Constantes.ESTADO_ACTIVO);
				entityPrograma.setFechaCreacion(new Date());
				entityPrograma.setPrograma(businessDelegatorView.getPrograma((long)FacesUtils.checkInteger(somPrograma)));
				entityPrograma.setUsuario(entity);
				entityPrograma.setUsuCreador(usuario.getIdUsuario());
				
				businessDelegatorView.saveProgramaUsuario(entityPrograma);
				data = null;

				FacesUtils.addInfoMessage("Usuario creado exitosamente correctamente");
				FacesUtils.addInfoMessage("Usuario y contraseña enviados al correo");
				action_clear();

			}

		} catch (Exception e) {			
			FacesUtils.addErrorMessage(e.getMessage());
			log.error("Error al crear el usuario "+e.getMessage(),e);
		}

		return "";

	}
    
    public String action_modify() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			

			if (usuario != null) {				
				

				entity.setCodigo(Long.parseLong(FacesUtils.checkString(txtCodigo)));
				entity.setIdentificacion(Long.parseLong(FacesUtils.checkString(txtIdentificacion)));
				entity.setNombre(FacesUtils.checkString(txtNombre));
				entity.setApellido(FacesUtils.checkString(txtApellido));
				entity.setCelular(Long.parseLong(FacesUtils.checkString(txtCelular)));
				entity.setCorreo(FacesUtils.checkString(txtCorreo));
				entity.setUsuModificador(usuario.getIdUsuario());
				entity.setGenero(FacesUtils.checkString(somGenero));
				entity.setFechaModificacion(new Date());
				
				if(entityTipoUsuario.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
					if(FacesUtils.checkString(somTipoUsuario)==null) {						
						throw new Exception("No hay selecionado tipo usuario");
					}else {
						entity.setTipoUsuario(businessDelegatorView.getTipoUsuario((long)(FacesUtils.checkInteger(somTipoUsuario))));
						entityPrograma.setActivo(Constantes.ESTADO_ACTIVO);
						entityPrograma.setPrograma(businessDelegatorView.getPrograma((long)FacesUtils.checkInteger(somPrograma)));
						entityPrograma.setFechaModificacion(new Date());								
						entityPrograma.setUsuModificador(usuario.getIdUsuario());
						
						businessDelegatorView.updateProgramaUsuario(entityPrograma);
					}
				}
				else {
					Object[] variable = {"usuario.idUsuario",true,entity.getIdUsuario(),"=","programa.idPrograma",true,FacesUtils.checkInteger(somPrograma),"=","activo",true,Constantes.ESTADO_ASIGNADO,"="};
					List<ProgramaUsuario> programaList = businessDelegatorView.findByCriteriaInProgramaUsuario(variable,null,null);
					if(programaList.size()!=0) {
						ProgramaUsuario programa = programaList.get(0);
						programa.setFechaModificacion(new Date());
						programa.setUsuModificador(usuario.getIdUsuario());
						programa.setActivo(Constantes.ESTADO_ACTIVO);
						
						entityPrograma.setUsuModificador(usuario.getIdUsuario());
						entityPrograma.setFechaModificacion(new Date());
						entityPrograma.setActivo(Constantes.ESTADO_ASIGNADO);
						
						businessDelegatorView.updateProgramaUsuario(programa);
						businessDelegatorView.updateProgramaUsuario(entityPrograma);
					}
				}
					
				
				
				
				businessDelegatorView.updateUsuario(entity);	
				
				
				
				
				data = null;

				FacesUtils.addInfoMessage("Usuario actualizado correctamente");
				action_clear();

			}

		} catch (Exception e) {			
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

    
    //Update vista
    public void changeFacultad() {
    	losProgramasSelectItem= null;
    	somPrograma.resetValue();
    	action_validar();
    }
    
    /* Getter y Setter*/
    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(InputText txtCelular) {
        this.txtCelular = txtCelular;
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public InputText getTxtIdentificacion() {
        return txtIdentificacion;
    }

    public void setTxtIdentificacion(InputText txtIdentificacion) {
        this.txtIdentificacion = txtIdentificacion;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    } 

    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }    

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

	public SelectOneMenu getSomTipoUsuario() {
		return somTipoUsuario;
	}

	public void setSomTipoUsuario(SelectOneMenu somTipoUsuario) {
		this.somTipoUsuario = somTipoUsuario;
	}

	public List<SelectItem> getLosTipoUsuarioSelectItem() {
		if(losTipoUsuarioSelectItem==null) {
			try {
				losTipoUsuarioSelectItem = new ArrayList<>();
				Object[] variable = {"activo",true,Constantes.ESTADO_ACTIVO,"="};
				for(TipoUsuario tipoUsuario:businessDelegatorView.findByCriteriaInTipoUsuario(variable,null,null)) {
					losTipoUsuarioSelectItem.add(new SelectItem(tipoUsuario.getIdTipoUsuario(),tipoUsuario.getNombre()));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return losTipoUsuarioSelectItem;
	}

	public void setLosTipoUsuarioSelectItem(List<SelectItem> losTipoUsuarioSelectItem) {
		this.losTipoUsuarioSelectItem = losTipoUsuarioSelectItem;
	}

	public SelectOneMenu getSomGenero() {
		return somGenero;
	}

	public void setSomGenero(SelectOneMenu somGenero) {
		this.somGenero = somGenero;
	}

	public SelectOneMenu getSomFacultas() {
		return somFacultas;
	}

	public void setSomFacultas(SelectOneMenu somFacultas) {
		this.somFacultas = somFacultas;
	}

	public SelectOneMenu getSomPrograma() {
		return somPrograma;
	}

	public void setSomPrograma(SelectOneMenu somPrograma) {
		this.somPrograma = somPrograma;
	}

	public List<SelectItem> getLosFacultadSelectItem() {
		if(losFacultadSelectItem==null) {				
			Object[] variable = {"activo",true,Constantes.ESTADO_ACTIVO,"="};
			losFacultadSelectItem = new ArrayList<>();				
			try {
				List<Facultad> list = businessDelegatorView.findByCriteriaInFacultad(variable,null,null);
				for (Facultad facultad : list) {
					losFacultadSelectItem.add(new SelectItem(facultad.getIdFacultad(),facultad.getNombre()));
				}
			} catch (Exception e) {
				
				log.error("Error" + e.getMessage(),e);
			}
		}
		return losFacultadSelectItem;
	}

	public void setLosFacultadSelectItem(List<SelectItem> losFacultadSelectItem) {
		this.losFacultadSelectItem = losFacultadSelectItem;
	}

	public List<SelectItem> getLosProgramasSelectItem() {
		if(losProgramasSelectItem==null && somFacultas.getValue()!=null ) {				
			Object[] variable = {"facultad.idFacultad",true,FacesUtils.checkInteger(somFacultas),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
			losProgramasSelectItem = new ArrayList<>();				
			try {
				List<Programa> list = businessDelegatorView.findByCriteriaInPrograma(variable,null,null);
				for (Programa programa : list) {
					losProgramasSelectItem.add(new SelectItem(programa.getIdPrograma(),programa.getNombre()));
				}
			} catch (Exception e) {
				
				log.debug("Error" + e.getMessage());
			}
		}	
		return losProgramasSelectItem;
	}

	public void setLosProgramasSelectItem(List<SelectItem> losProgramasSelectItem) {
		this.losProgramasSelectItem = losProgramasSelectItem;
	}

	public boolean isMostrarTipo() {
		return mostrarTipo;
	}

	public void setMostrarTipo(boolean mostrarTipo) {
		this.mostrarTipo = mostrarTipo;
	}
}
