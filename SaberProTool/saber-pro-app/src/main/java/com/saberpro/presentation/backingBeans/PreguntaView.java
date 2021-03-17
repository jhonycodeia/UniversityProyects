package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.PreguntaDTO;
import com.saberpro.modelo.dto.TipoModuloDTO;
import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.extensions.component.ckeditor.CKEditor;
import org.primefaces.model.UploadedFile;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PreguntaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PreguntaView.class);
    
    private boolean cargo = true;
    
    private String content;
    private String contentRespuesta1;
    private String contentRespuesta2;
    private String contentRespuesta3;
    private String contentRespuesta4;
    
    private InputNumber porcentajeAciertoRespuesta1;
    private InputNumber porcentajeAciertoRespuesta2;
    private InputNumber porcentajeAciertoRespuesta3;
    private InputNumber porcentajeAciertoRespuesta4;
    
    
    
    private SelectOneMenu somTipoModulo;
	private SelectOneMenu somModulo;
    
    private InputTextarea txtRetroalimentacion;
    
    private UploadedFile chooseImportFile;
    private UploadedFile choosePregunta;
    private UploadedFile chooseRespuesta1;
    private UploadedFile chooseRespuesta2;
    private UploadedFile chooseRespuesta3;
    private UploadedFile chooseRespuesta4;
    
    private CommandButton importFile;
    private CommandButton subirPregunta;
    private CommandButton subirRespuesta1;
    private CommandButton subirRespuesta2;
    private CommandButton subirRespuesta3;
    private CommandButton subirRespuesta4;
    private CommandButton crear;
    private CommandButton actualizar;
    private CommandButton cargar;
    
    private List<SelectItem> lasTipoModuloSelectItem;
    private List<SelectItem> lasModuloSelectItem;
    private List<SelectItem> lasModuloSelectItemFilter;
    
    private List<Pregunta> data;
    
    private PreguntaDTO selectedPregunta;
    
    private Pregunta entity;
    
    private List<Respuesta> entityRespuestas;
    
    private boolean showDialog;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PreguntaView() {
        super();      
     }
    
    public void listener_txtId() {
    	try {
    		if(cargo) {
    			FacesContext facesContext = FacesContext.getCurrentInstance();
        		Map params = facesContext.getExternalContext().getRequestParameterMap();
        		Long id= new Long((String) params.get("id"));
        		
        		if(id!=null) {
        			Object[] variable = {"pregunta",true,id,"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
            		
            		entity = businessDelegatorView.getPregunta(id);	
            		
            		Modulo modulo = businessDelegatorView.getModulo(entity.getModulo().getIdModulo());
            		TipoModulo tipoModulo = businessDelegatorView.getTipoModulo(modulo.getTipoModulo().getIdTipoModulo());   		
        			
        			entityRespuestas = businessDelegatorView.findByCriteriaInRespuesta(variable,null,null);
        			
        			somTipoModulo.setValue(tipoModulo.getIdTipoModulo());
        			somModulo.setValue(modulo.getIdModulo());
        			
        			txtRetroalimentacion.setValue(entity.getRetroalimentacion());
        			content = entity.getDescripcionPregunta();
        			
        			contentRespuesta1 = entityRespuestas.get(0).getDescripcionRespuesta();
        			contentRespuesta2 = entityRespuestas.get(1).getDescripcionRespuesta();
        			contentRespuesta3 = entityRespuestas.get(2).getDescripcionRespuesta();
        			contentRespuesta4 = entityRespuestas.get(3).getDescripcionRespuesta();
        			
        			porcentajeAciertoRespuesta1.setValue(entityRespuestas.get(0).getPorcentajeAcierto());
        			porcentajeAciertoRespuesta2.setValue(entityRespuestas.get(1).getPorcentajeAcierto());
        			porcentajeAciertoRespuesta3.setValue(entityRespuestas.get(2).getPorcentajeAcierto());
        			porcentajeAciertoRespuesta4.setValue(entityRespuestas.get(3).getPorcentajeAcierto());
        			
        			crear.setDisabled(true);
        			actualizar.setDisabled(false);
        		}
    		
    			cargo = false;
    			
    		}
    		
					
		} catch (Exception e) {
			log.debug("Error "+e.getMessage());
		}
    }
    
    public String action_create() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null && FacesUtils.checkInteger(porcentajeAciertoRespuesta1)!=null && FacesUtils.checkInteger(porcentajeAciertoRespuesta2)!=null
					&& FacesUtils.checkInteger(porcentajeAciertoRespuesta3)!=null && FacesUtils.checkInteger(porcentajeAciertoRespuesta4)!=null && !contentRespuesta1.isEmpty()
					&& !contentRespuesta2.isEmpty() && !contentRespuesta3.isEmpty() && !contentRespuesta4.isEmpty()) {				
				
				entity = new Pregunta();

				entity.setActivo(Constantes.ESTADO_ACTIVO);
				entity.setDescripcionPregunta(content);
				entity.setFechaCreacion(new Date());
				entity.setModulo(businessDelegatorView.getModulo(FacesUtils.checkLong(somModulo)));
				entity.setTipoPregunta(businessDelegatorView.getTipoPregunta(Constantes.PREGUNTA_TYPE_MULTIPLE));
				entity.setRetroalimentacion(FacesUtils.checkString(txtRetroalimentacion));
				entity.setUsuCreador(usuario.getIdUsuario());
				
				
				
				List<Respuesta> listRespuesta = new ArrayList<>();

				Respuesta respuesta = new Respuesta();
				
				respuesta.setActivo(Constantes.ESTADO_ACTIVO);
				respuesta.setDescripcionRespuesta(contentRespuesta1);
				respuesta.setFechaCreacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta1));				
				respuesta.setUsuCreador(usuario.getIdUsuario());
				
				listRespuesta.add(respuesta);
				
				respuesta = new Respuesta();
				
				respuesta.setActivo(Constantes.ESTADO_ACTIVO);
				respuesta.setDescripcionRespuesta(contentRespuesta2);
				respuesta.setFechaCreacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta2));				
				respuesta.setUsuCreador(usuario.getIdUsuario());
				
				listRespuesta.add(respuesta);
				
				respuesta = new Respuesta();
				
				respuesta.setActivo(Constantes.ESTADO_ACTIVO);
				respuesta.setDescripcionRespuesta(contentRespuesta3);
				respuesta.setFechaCreacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta3));			
				respuesta.setUsuCreador(usuario.getIdUsuario());
				
				listRespuesta.add(respuesta);
				
				respuesta = new Respuesta();
				
				respuesta.setActivo(Constantes.ESTADO_ACTIVO);
				respuesta.setDescripcionRespuesta(contentRespuesta4);
				respuesta.setFechaCreacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta4));				
				respuesta.setUsuCreador(usuario.getIdUsuario());
				
				listRespuesta.add(respuesta);
				
				businessDelegatorView.savePregunta(entity, listRespuesta);

				FacesUtils.addInfoMessage("Pregunta creada correctamente");
				
				action_clear();
				

			}
			else {
				FacesUtils.addErrorMessage("No se pudo crear la pregunta, por favor verifique los datos");
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}
    
    public String action_clear() {
		entity = null;
		selectedPregunta = null;

		txtRetroalimentacion.resetValue();
		
		somModulo.resetValue();
		somTipoModulo.resetValue();
		
		content = "";
		contentRespuesta1 = "";
		contentRespuesta2 = "";
		contentRespuesta3 = "";
		contentRespuesta4 = "";
		
		porcentajeAciertoRespuesta1.resetValue();
		porcentajeAciertoRespuesta2.resetValue();
		porcentajeAciertoRespuesta3.resetValue();
		porcentajeAciertoRespuesta4.resetValue();
		

		return "";
	}
    
    public String action_modify() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");			

			if (usuario != null && FacesUtils.checkInteger(porcentajeAciertoRespuesta1)!=null && FacesUtils.checkInteger(porcentajeAciertoRespuesta2)!=null
					&& FacesUtils.checkInteger(porcentajeAciertoRespuesta3)!=null && FacesUtils.checkInteger(porcentajeAciertoRespuesta4)!=null && !contentRespuesta1.isEmpty()
					&& !contentRespuesta2.isEmpty() && !contentRespuesta3.isEmpty() && !contentRespuesta4.isEmpty()) {			
				
				entity.setActivo(Constantes.ESTADO_ACTIVO);
				entity.setDescripcionPregunta(content);
				entity.setFechaModificacion(new Date());
				entity.setModulo(businessDelegatorView.getModulo(FacesUtils.checkLong(somModulo)));
				entity.setTipoPregunta(businessDelegatorView.getTipoPregunta(Constantes.PREGUNTA_TYPE_MULTIPLE));
				entity.setRetroalimentacion(FacesUtils.checkString(txtRetroalimentacion));
				entity.setUsuModificador(usuario.getIdUsuario());
				
				businessDelegatorView.updatePregunta(entity);			

				Respuesta respuesta = entityRespuestas.get(0);				
				
				respuesta.setDescripcionRespuesta(contentRespuesta1);
				respuesta.setFechaModificacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta1));				
				respuesta.setUsuModificador(usuario.getIdUsuario());
				
				businessDelegatorView.updateRespuesta(respuesta);
				
				respuesta = entityRespuestas.get(1);				
				
				respuesta.setDescripcionRespuesta(contentRespuesta2);
				respuesta.setFechaModificacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta2));				
				respuesta.setUsuModificador(usuario.getIdUsuario());
				
				businessDelegatorView.updateRespuesta(respuesta);
				
				respuesta = entityRespuestas.get(2);
				
				
				respuesta.setDescripcionRespuesta(contentRespuesta3);
				respuesta.setFechaModificacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta3));				
				respuesta.setUsuModificador(usuario.getIdUsuario());
				
				businessDelegatorView.updateRespuesta(respuesta);
				
				respuesta = entityRespuestas.get(3);
				
				
				respuesta.setDescripcionRespuesta(contentRespuesta4);
				respuesta.setFechaModificacion(new Date());
				respuesta.setPorcentajeAcierto(FacesUtils.checkInteger(porcentajeAciertoRespuesta4));				
				respuesta.setUsuModificador(usuario.getIdUsuario());
				
				businessDelegatorView.updateRespuesta(respuesta);

				FacesUtils.addInfoMessage("Pregunta actualizada correctamente");
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("/saber-pro-app/XHTML/Pregunta/verPregunta.xhtml");
				
			}
			else {
				FacesUtils.addErrorMessage("No se pudo actualizar la pregunta, por favor verifique los datos");
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
    public String getModulo(long id) {
    	try {
			return businessDelegatorView.getModulo(id).getNombre();
		} catch (Exception e) {
			return e.getMessage();
		}
    }
    
    public void changeTipoModulo() {
    	lasModuloSelectItem = null;
    }
    
    public void importFilePregunta() {
    	try {
			if(chooseImportFile!=null) {
				
				Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
				
				String ext = chooseImportFile.getFileName().substring(chooseImportFile.getFileName().lastIndexOf("."));
				businessDelegatorView.importFilePregunta(chooseImportFile.getInputstream(),usuario.getIdUsuario(),ext);
				
				data = null;
				
				FacesUtils.addInfoMessage("Preguntas importadas correctamente");
			}
			
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			log.error("Error importando el archivo "+e.getMessage(),e);
		}
    }
    
    public void subirImagenPregunta() {
    	try {
    		if(choosePregunta!=null) {
    			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    			
    			String ruta= (String) servletContext.getRealPath("/")+"pregunta/"+choosePregunta.getFileName();
    			String httpRuta = businessDelegatorView.getParametro(Constantes.PARAMETRO_WEB_PREGUNTA).getValor()+choosePregunta.getFileName();
    			
    			businessDelegatorView.subirFilePregunta(choosePregunta.getInputstream(),ruta);
    			
    			   			
    			
    			content = content +"<p><img width=\"300px\"   alt=\"\" src=\""+httpRuta+"\"/></p>"; 
    			
    			FacesUtils.addInfoMessage("Se subió el archivo correctamente");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void subirImagenRespuesta1() {
    	try {
    		if(chooseRespuesta1!=null) {
    			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    			
    			String ruta= (String) servletContext.getRealPath("/")+"respuesta/"+chooseRespuesta1.getFileName();
    			String httpRuta = businessDelegatorView.getParametro(Constantes.PARAMETRO_WEB_RESPUESTA).getValor()+chooseRespuesta1.getFileName();
    			
    			businessDelegatorView.subirFilePregunta(chooseRespuesta1.getInputstream(),ruta);
    			
    						
    			
    			contentRespuesta1 = contentRespuesta1 +"<p><img width=\"300px\" alt=\"\" src=\""+httpRuta+"\"/></p>"; 
    			
    			FacesUtils.addInfoMessage("Se subió el archivo correctamente");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void subirImagenRespuesta2() {
    	try {
    		if(chooseRespuesta2!=null) {
    			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    			
    			String ruta= (String) servletContext.getRealPath("/")+"respuesta/"+chooseRespuesta2.getFileName();
    			String httpRuta = businessDelegatorView.getParametro(Constantes.PARAMETRO_WEB_RESPUESTA).getValor()+chooseRespuesta2.getFileName();
    			
    			businessDelegatorView.subirFilePregunta(chooseRespuesta2.getInputstream(),ruta);
    			
    			  			
    			
    			contentRespuesta2 = contentRespuesta2 +"<p><img width=\"300px\" alt=\"\" src=\""+httpRuta+"\"/></p>"; 
    			
    			FacesUtils.addInfoMessage("Se subió el archivo correctamente");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void subirImagenRespuesta3() {
    	try {
    		if(chooseRespuesta3!=null) {
    			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    			
    			String ruta= (String) servletContext.getRealPath("/")+"respuesta/"+chooseRespuesta3.getFileName();
    			String httpRuta = businessDelegatorView.getParametro(Constantes.PARAMETRO_WEB_RESPUESTA).getValor()+chooseRespuesta3.getFileName();
    			
    			businessDelegatorView.subirFilePregunta(chooseRespuesta3.getInputstream(),ruta);
    			
    		
    			contentRespuesta3 = contentRespuesta3 +"<p><img  width=\"300px\" alt=\"\" src=\""+httpRuta+"\"/></p>"; 
    			
    			FacesUtils.addInfoMessage("Se subió el archivo correctamente");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void subirImagenRespuesta4() {
    	try {
    		if(chooseRespuesta4!=null) {
    			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    			
    			String ruta= (String) servletContext.getRealPath("/")+"respuesta/"+chooseRespuesta4.getFileName();
    			String httpRuta = businessDelegatorView.getParametro(Constantes.PARAMETRO_WEB_RESPUESTA).getValor()+chooseRespuesta4.getFileName();
    			
    			businessDelegatorView.subirFilePregunta(chooseRespuesta4.getInputstream(),ruta);
    			
    						
    			
    			contentRespuesta4 = contentRespuesta4 +"<p><img width=\"300px\" alt=\"\" src=\""+httpRuta+"\"/></p>"; 
    			
    			FacesUtils.addInfoMessage("Se subió el archivo correctamente");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }

    public List<Pregunta> getData() {
        try {
            if (data == null) {
            	if(VariablesSession.tipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_DIRECTOR || VariablesSession.tipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_ADMIN )
                data = businessDelegatorView.getPregunta();
            }
            else if(VariablesSession.tipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_DOCENTE) {
            	Object[] variable = {"usuCreador",true,VariablesSession.usuario.getIdUsuario(),"="};
            	data = businessDelegatorView.findByCriteriaInPregunta(variable, null, null);
            }
        } catch (Exception e) {
        	log.error("Error de "+e.getMessage(),e);
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<Pregunta> pregunta) {
        this.data = pregunta;
    }

    public PreguntaDTO getSelectedPregunta() {
        return selectedPregunta;
    }

    public void setSelectedPregunta(PreguntaDTO pregunta) {
        this.selectedPregunta = pregunta;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentRespuesta1() {
		return contentRespuesta1;
	}

	public void setContentRespuesta1(String contentRespuesta1) {
		this.contentRespuesta1 = contentRespuesta1;
	}

	public String getContentRespuesta2() {
		return contentRespuesta2;
	}

	public void setContentRespuesta2(String contentRespuesta2) {
		this.contentRespuesta2 = contentRespuesta2;
	}

	public String getContentRespuesta3() {
		return contentRespuesta3;
	}

	public void setContentRespuesta3(String contentRespuesta3) {
		this.contentRespuesta3 = contentRespuesta3;
	}

	public String getContentRespuesta4() {
		return contentRespuesta4;
	}

	public void setContentRespuesta4(String contentRespuesta4) {
		this.contentRespuesta4 = contentRespuesta4;
	}

	public UploadedFile getChoosePregunta() {
		return choosePregunta;
	}

	public void setChoosePregunta(UploadedFile choosePregunta) {
		this.choosePregunta = choosePregunta;
	}

	public CommandButton getSubirPregunta() {
		return subirPregunta;
	}

	public void setSubirPregunta(CommandButton subirPregunta) {
		this.subirPregunta = subirPregunta;
	}

	

	public InputTextarea getTxtRetroalimentacion() {
		return txtRetroalimentacion;
	}

	public void setTxtRetroalimentacion(InputTextarea txtRetroalimentacion) {
		this.txtRetroalimentacion = txtRetroalimentacion;
	}

	public UploadedFile getChooseRespuesta1() {
		return chooseRespuesta1;
	}

	public void setChooseRespuesta1(UploadedFile chooseRespuesta1) {
		this.chooseRespuesta1 = chooseRespuesta1;
	}

	public UploadedFile getChooseRespuesta2() {
		return chooseRespuesta2;
	}

	public void setChooseRespuesta2(UploadedFile chooseRespuesta2) {
		this.chooseRespuesta2 = chooseRespuesta2;
	}

	public UploadedFile getChooseRespuesta3() {
		return chooseRespuesta3;
	}

	public void setChooseRespuesta3(UploadedFile chooseRespuesta3) {
		this.chooseRespuesta3 = chooseRespuesta3;
	}

	public UploadedFile getChooseRespuesta4() {
		return chooseRespuesta4;
	}

	public void setChooseRespuesta4(UploadedFile chooseRespuesta4) {
		this.chooseRespuesta4 = chooseRespuesta4;
	}

	

	public CommandButton getSubirRespuesta1() {
		return subirRespuesta1;
	}

	public void setSubirRespuesta1(CommandButton subirRespuesta1) {
		this.subirRespuesta1 = subirRespuesta1;
	}

	public CommandButton getSubirRespuesta2() {
		return subirRespuesta2;
	}

	public void setSubirRespuesta2(CommandButton subirRespuesta2) {
		this.subirRespuesta2 = subirRespuesta2;
	}

	public CommandButton getSubirRespuesta3() {
		return subirRespuesta3;
	}

	public void setSubirRespuesta3(CommandButton subirRespuesta3) {
		this.subirRespuesta3 = subirRespuesta3;
	}

	public CommandButton getSubirRespuesta4() {
		return subirRespuesta4;
	}

	public void setSubirRespuesta4(CommandButton subirRespuesta4) {
		this.subirRespuesta4 = subirRespuesta4;
	}

	public UploadedFile getChooseImportFile() {
		return chooseImportFile;
	}

	public void setChooseImportFile(UploadedFile chooseImportFile) {
		this.chooseImportFile = chooseImportFile;
	}

	public CommandButton getImportFile() {
		return importFile;
	}

	public void setImportFile(CommandButton importFile) {
		this.importFile = importFile;
	}

	public SelectOneMenu getSomTipoModulo() {
		return somTipoModulo;
	}

	public void setSomTipoModulo(SelectOneMenu somTipoModulo) {
		this.somTipoModulo = somTipoModulo;
	}

	public SelectOneMenu getSomModulo() {
		return somModulo;
	}

	public void setSomModulo(SelectOneMenu somModulo) {
		this.somModulo = somModulo;
	}

	public List<SelectItem> getLasTipoModuloSelectItem() {
		if(lasTipoModuloSelectItem==null) {
			Object[] variable = {"activo",true,Constantes.ESTADO_ACTIVO,"="};
			lasTipoModuloSelectItem = new ArrayList<>();
			try {
				List<TipoModulo> list = businessDelegatorView.findByCriteriaInTipoModulo(variable,null,null);
				for (TipoModulo tipoModulo : list) {
					lasTipoModuloSelectItem.add(new SelectItem(tipoModulo.getIdTipoModulo(), tipoModulo.getNombre()));
				}
			} catch (Exception e) {
				log.debug("Error" + e.getMessage());
			}
		}
		return lasTipoModuloSelectItem;
	}

	public void setLasTipoModuloSelectItem(List<SelectItem> lasTipoModuloSelectItem) {
		this.lasTipoModuloSelectItem = lasTipoModuloSelectItem;
	}

	public List<SelectItem> getLasModuloSelectItem() {
		
		if(lasModuloSelectItem==null && FacesUtils.checkInteger(somTipoModulo)!=null) {				
				Object[] variable = {"tipoModulo",true,FacesUtils.checkInteger(somTipoModulo),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
				lasModuloSelectItem = new ArrayList<>();				
				try {
					log.info("El tipo de usuario es "+VariablesSession.tipoUsuario.getIdTipoUsuario());
					List<Modulo> list = null;
					if(VariablesSession.tipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_DOCENTE) {
						list = businessDelegatorView.findByProgramaModulo(VariablesSession.programa.getIdPrograma());
					}
					else if(VariablesSession.tipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_DIRECTOR || VariablesSession.tipoUsuario.getIdTipoUsuario()==Constantes.USER_TYPE_ADMIN ) {
						list = businessDelegatorView.findByCriteriaInModulo(variable,null,null);
					}
					
					
					for (Modulo modulo : list) {
						lasModuloSelectItem.add(new SelectItem(modulo.getIdModulo(),modulo.getNombre()));
					}
				} catch (Exception e) {
					
					log.debug("Error" + e.getMessage());
				}
			}			
		
		return lasModuloSelectItem;
	}

	public void setLasModuloSelectItem(List<SelectItem> lasModuloSelectItem) {
		this.lasModuloSelectItem = lasModuloSelectItem;
	}

	public InputNumber getPorcentajeAciertoRespuesta1() {
		return porcentajeAciertoRespuesta1;
	}

	public void setPorcentajeAciertoRespuesta1(InputNumber porcentajeAciertoRespuesta1) {
		this.porcentajeAciertoRespuesta1 = porcentajeAciertoRespuesta1;
	}

	public InputNumber getPorcentajeAciertoRespuesta2() {
		return porcentajeAciertoRespuesta2;
	}

	public void setPorcentajeAciertoRespuesta2(InputNumber porcentajeAciertoRespuesta2) {
		this.porcentajeAciertoRespuesta2 = porcentajeAciertoRespuesta2;
	}

	public InputNumber getPorcentajeAciertoRespuesta3() {
		return porcentajeAciertoRespuesta3;
	}

	public void setPorcentajeAciertoRespuesta3(InputNumber porcentajeAciertoRespuesta3) {
		this.porcentajeAciertoRespuesta3 = porcentajeAciertoRespuesta3;
	}

	public InputNumber getPorcentajeAciertoRespuesta4() {
		return porcentajeAciertoRespuesta4;
	}

	public void setPorcentajeAciertoRespuesta4(InputNumber porcentajeAciertoRespuesta4) {
		this.porcentajeAciertoRespuesta4 = porcentajeAciertoRespuesta4;
	}

	public CommandButton getCrear() {
		return crear;
	}

	public void setCrear(CommandButton crear) {
		this.crear = crear;
	}

	public CommandButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(CommandButton actualizar) {
		this.actualizar = actualizar;
	}

	public CommandButton getCargar() {
		listener_txtId();
		return cargar;
	}

	public void setCargar(CommandButton cargar) {
		this.cargar = cargar;
	}
	
	public boolean getCargo() {
		return cargo;
	}
	
	public void setCargo(boolean cargo) {
		this.cargo = cargo;
	}

	public List<SelectItem> getLasModuloSelectItemFilter() {
		if(lasModuloSelectItemFilter==null) {				
			Object[] variable = {"activo",true,Constantes.ESTADO_ACTIVO,"="};
			lasModuloSelectItemFilter = new ArrayList<>();				
			try {
				List<Modulo> list = businessDelegatorView.findByCriteriaInModulo(variable,null,null);
				for (Modulo modulo : list) {
					lasModuloSelectItemFilter.add(new SelectItem(modulo.getIdModulo(),modulo.getNombre()));
				}
			} catch (Exception e) {
				
				log.debug("Error" + e.getMessage());
			}
		}		
		return lasModuloSelectItemFilter;
	}

	public void setLasModuloSelectItemFilter(List<SelectItem> lasModuloSelectItemFilter) {
		this.lasModuloSelectItemFilter = lasModuloSelectItemFilter;
	}

	
}
