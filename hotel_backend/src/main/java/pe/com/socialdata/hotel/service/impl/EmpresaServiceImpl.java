package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.Empresa;
import pe.com.socialdata.hotel.model.EmpresaModel;
import pe.com.socialdata.hotel.model.convert.EmpresaConvert;
import pe.com.socialdata.hotel.repository.EmpresaRepository;

import pe.com.socialdata.hotel.service.EmpresaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;

@Service("empresaService")
public class EmpresaServiceImpl implements EmpresaService {

	
	private static Log LOG = LogFactory.getLog(EmpresaServiceImpl.class);
	
	@Autowired
	EmpresaRepository  empresaRepository;
	
	@Autowired
	EmpresaConvert 		empresaConvert;
	
	
	@Override
	public EmpresaModel save(EmpresaModel empresaModel) {
		LOG.debug("inicia  save");
		try {
			Empresa empresa = empresaConvert.convertEmpresaModel2Empresa(empresaModel);
			
			empresa=empresaRepository.save(empresa);
			empresaModel = empresaConvert.convertEmpresa2EmpresaModel(empresa);
			
		
		} catch (Exception ex) {
			//LOG.error(ex.getMessage(), ex);
			throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO));
		}
		finally{
			LOG.debug("Fin save");
		}
		
		return empresaModel;
	}

	@Override
	public List<EmpresaModel> listAllEmpresa() {
		LOG.debug("listAllEmpresa");
		List<Empresa> empresas = empresaRepository.findAll();
		List<EmpresaModel> empresasModel = new ArrayList<EmpresaModel>();
		
		for(Empresa obj : empresas) {
			empresasModel.add( empresaConvert.convertEmpresa2EmpresaModel(obj));
		}
		
		return empresasModel;
	}

	@Override
	public EmpresaModel findEmpresaModelById(Integer id) {
		return	empresaConvert.convertEmpresa2EmpresaModel(empresaRepository.findById(id));
		 
	}

	@Override
	public void removeEmpresa(Integer id) {
		Empresa empresa =empresaRepository.findById(id);
		if (null !=empresa) {
			empresaRepository.delete(empresa);
		}else {
			LOG.warn("empresa no existe!");
		}
		
	}

	@Override
	public List<EmpresaModel> searchEmpresaByName(String name) {
		List<Empresa> empresas = empresaRepository.findByNombreLike(name);
		List<EmpresaModel> empresasModel= new ArrayList<EmpresaModel>();
		for(Empresa obj: empresas ) {
			empresasModel.add(empresaConvert.convertEmpresa2EmpresaModel(obj));
		}
		return empresasModel;
	}

	
}
