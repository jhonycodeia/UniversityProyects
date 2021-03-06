package com.saberpro.presentation.backingBeans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.saberpro.modelo.dto.GrupoOpcionDTO;
import com.saberpro.modelo.dto.OpcionDTO;
import com.saberpro.modelo.dto.UsuarioDTO;
import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;


@ViewScoped
@ManagedBean(name = "menuView")
public class MenuView {

	private final static Logger log = LoggerFactory.getLogger(MenuView.class);
			
	private MenuModel model;

	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public void initMenuView() {
		
		UsuarioDTO usuarioDTO = (UsuarioDTO)FacesUtils.getfromSession("usuarioDTO");		
		
		if(usuarioDTO!=null) {
			
			model = new DefaultMenuModel();			
			
			try {			
				
				List<GrupoOpcionDTO> grupos =  businessDelegatorView.findByDataTipoUsuarioGrupoOpcion(usuarioDTO.getIdTipoUsuario_TipoUsuario(),Constantes.ESTADO_ACTIVO);
							
				for (GrupoOpcionDTO grupoOpcionDTO : grupos) {
					
					DefaultSubMenu  subMenu = new DefaultSubMenu();
					subMenu.setLabel(grupoOpcionDTO.getNombre());
					subMenu.setIcon(grupoOpcionDTO.getIcon());
					
					List<OpcionDTO> opciones = businessDelegatorView.findByDataGrupoOpcion(grupoOpcionDTO.getIdGrupoOpcion(),Constantes.ESTADO_ACTIVO);
				
					for (OpcionDTO opcionDTO : opciones) {
						
						DefaultMenuItem menuItem = new DefaultMenuItem();
						menuItem.setAjax(false);
						menuItem.setHref(opcionDTO.getRuta());
						menuItem.setValue(opcionDTO.getNombre());
						menuItem.setTitle(opcionDTO.getNombre());
						
						subMenu.addElement(menuItem);
					}
					model.addElement(subMenu);
				}
				
				
			
			} catch (Exception e) {
				log.debug("error de "+e.getMessage());
			}
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/saber-pro-app/login.xhtml");
			} catch (IOException e) {
				log.debug("error de "+e.getMessage());
			}
		}
	}	

	public MenuModel getModel() {
		if(model == null) {
			initMenuView();
		}
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}
	

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}
