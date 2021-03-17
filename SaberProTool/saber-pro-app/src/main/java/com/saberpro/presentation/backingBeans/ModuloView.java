package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;
import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ModuloDTO;
import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ModuloView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ModuloView.class);
    
    private boolean crear = true;
    
    private InputTextarea txtDescripcion;
    private InputText txtNombre;
    
    private SelectOneMenu somActivo;
	private SelectOneMenu somTipoModulo;
    
    private Spinner txtPrioridad;
    private Spinner txtCantPreguntas;
    
    private CommandButton btnSave;
    private CommandButton btnModify;    
    private CommandButton btnClear;
    
    private List<ModuloDTO> data;
    
    private List<SelectItem> lasTipoModuloSelectItem;
    
    private ModuloDTO selectedModulo;
    
    private Modulo entity;
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ModuloView() {
        super();
    }
    
    
    
    public String getTipoModulo(long id) {
    	try {
			return businessDelegatorView.getTipoModulo(id).getNombre();
		} catch (Exception e) {
			return "";
		}
    }
    
   
    public void editar_action(String nombre) {   	
    	
    	txtNombre.setValue(nombre);
    	listener_txtId();
    }
    //Listener para txtNombre 
    public void listener_txtId() {
		try {
			String nombre = txtNombre.getValue().toString().trim();			
			//Se consulta el módulo por nombre
			entity = businessDelegatorView.findByNombreModulo(nombre);

		} catch (Exception e) {
			entity = null;			
		}
		//Si no se encuntra un módulo con ese nombre, se habilita la función de crear uno nuevo
		if (entity == null) {
			
			crear = true;
			
			txtDescripcion.resetValue();
			
			txtCantPreguntas.resetValue();
			txtPrioridad.resetValue();
			
			somActivo.resetValue();
			somTipoModulo.resetValue();			

			btnSave.setDisabled(false);
			btnModify.setDisabled(true);
			//Si existe un módulo con ese nombre, se setean los datos del módulo en los campos de la vista
		} else {
			
			crear = false;
			
			txtNombre.setValue(entity.getNombre());
			txtDescripcion.setValue(entity.getDescripcion());
			
			txtCantPreguntas.setValue(entity.getCantidadPreguntas());
			txtPrioridad.setValue(entity.getPrioridad());
			
			somActivo.setValue(entity.getActivo());
			somTipoModulo.setValue(entity.getTipoModulo().getIdTipoModulo());
			
			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
		}
		
		action_validar();
	}
    
    public void verificar(CommandButton input) {
    	try {
    		if(FacesUtils.checkString(txtNombre).isEmpty()) 
        		input.setDisabled(true);    	
        	if(FacesUtils.checkLong(txtCantPreguntas)==null)
        		input.setDisabled(true);
        	if(FacesUtils.checkLong(txtPrioridad)==null)
        		input.setDisabled(true);
        	if(FacesUtils.checkString(somActivo)==null)
        		input.setDisabled(true);
        	if(FacesUtils.checkString(somTipoModulo)==null)
        		input.setDisabled(true);
		} catch (Exception e) {			
			log.debug(e.getMessage());
		}
    	
    		
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
    //Método para limpiar los campos de la vista
    public String action_clear() {

		entity = null;
		selectedModulo = null;

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);

		txtDescripcion.resetValue();
		txtNombre.resetValue();
		
		txtCantPreguntas.resetValue();
		txtPrioridad.resetValue();
		
		somActivo.resetValue();
		somTipoModulo.resetValue();

		return "";
	}
    //Método para crear un módulo
    public String action_create() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {				
				//Se instancia un nuevo módulo
				entity = new Modulo();
				//Se hidratan los datos del objeto módulo
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));				
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setCantidadPreguntas(FacesUtils.checkLong(txtCantPreguntas));
				entity.setPrioridad(FacesUtils.checkLong(txtPrioridad));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(usuario.getIdUsuario());
				entity.setTipoModulo(businessDelegatorView.getTipoModulo(FacesUtils.checkLong(somTipoModulo)));
				//se crea el nuevo módulo
				businessDelegatorView.saveModulo(entity);			

				data = null;

				FacesUtils.addInfoMessage("Se guardó exitosamente el módulo");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}
    //Método para modificar un módulo
    public String action_modify() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			String nombre = FacesUtils.checkString(txtNombre);

			if (usuario != null) {				
				//Se consulta el módulo por nombre
				entity = businessDelegatorView.findByNombreModulo(nombre);
				//Se modifican los datos del módulo encontrado
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));				
				entity.setCantidadPreguntas(FacesUtils.checkLong(txtCantPreguntas));
				entity.setPrioridad(FacesUtils.checkLong(txtPrioridad));
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaModificacion(new Date());
				entity.setUsuModificador(usuario.getIdUsuario());
				entity.setTipoModulo(businessDelegatorView.getTipoModulo(FacesUtils.checkLong(somTipoModulo)));
				//Se actualiza el objeto módulo con los nuevos datos
				businessDelegatorView.updateModulo(entity);			

				data = null;

				FacesUtils.addInfoMessage("Se actualizó exitosamente el modulo");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

    public InputTextarea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputTextarea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public Spinner getTxtPrioridad() {
        return txtPrioridad;
    }

    public void setTxtPrioridad(Spinner txtPrioridad) {
        this.txtPrioridad = txtPrioridad;
    }

    public List<ModuloDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataModulo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ModuloDTO> moduloDTO) {
        this.data = moduloDTO;
    }

    public ModuloDTO getSelectedModulo() {
        return selectedModulo;
    }

    public void setSelectedModulo(ModuloDTO modulo) {
        this.selectedModulo = modulo;
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

	public List<SelectItem> getLasTipoModuloSelectItem() {
		if(lasTipoModuloSelectItem==null) {
			lasTipoModuloSelectItem = new ArrayList<>();
			try {
				for (TipoModulo tipoModulo:businessDelegatorView.getTipoModulo()) {
					lasTipoModuloSelectItem.add(new SelectItem(tipoModulo.getIdTipoModulo(), tipoModulo.getNombre()));
				}
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
		}
		return lasTipoModuloSelectItem;
	}

	public void setLasTipoModuloSelectItem(List<SelectItem> lasTipoModuloSelectItem) {
		this.lasTipoModuloSelectItem = lasTipoModuloSelectItem;
	}

	public Spinner getTxtCantPreguntas() {
		return txtCantPreguntas;
	}

	public void setTxtCantPreguntas(Spinner txtCantPreguntas) {
		this.txtCantPreguntas = txtCantPreguntas;
	}

	public SelectOneMenu getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}

	public SelectOneMenu getSomTipoModulo() {
		return somTipoModulo;
	}

	public void setSomTipoModulo(SelectOneMenu somTipoModulo) {
		this.somTipoModulo = somTipoModulo;
	}
}
