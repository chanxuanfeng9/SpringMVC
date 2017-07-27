package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProviderMapper;

import entity.SmbmsProvider;
@Service
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	private ProviderMapper providerMapper;

	@Override
	public List<SmbmsProvider> getProviderByProName(String proName) {
		
		return providerMapper.getProviderByProName(proName);
	}

	@Override
	public List<SmbmsProvider> getProviders() {		
		return providerMapper.getProviders();
	}

	@Override
	public int addProvider(SmbmsProvider provider) {		
		return providerMapper.addProvider(provider);
	}

	@Override
	public int updateProvider(SmbmsProvider provider) {
		return providerMapper.updateProvider(provider);
	}

	@Override
	public SmbmsProvider getProviderById(Integer id) {
		return providerMapper.getProviderById(id);
	}

	@Override
	public int delProvider(Integer id) {
		return providerMapper.delProvider(id);
	}

}
