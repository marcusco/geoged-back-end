package br.com.geoged.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geoged.entity.VooCordenadaAcaoBin;
import br.com.geoged.repositoty.VooCordenadaAcaoBinRepository;
import br.com.geoged.service.VooCordenadaAcaoBinService;


@Service
@RequiredArgsConstructor
public class VooCordenadaAcaoBinServiceImpl extends ServiceBaseImpl<VooCordenadaAcaoBin> implements VooCordenadaAcaoBinService
{

	private final VooCordenadaAcaoBinRepository vooCordenadaAcaoBinRepository;
	@Override
	public VooCordenadaAcaoBin save(VooCordenadaAcaoBin entity)
	{
		return vooCordenadaAcaoBinRepository.save(entity);
	}

	public Optional<VooCordenadaAcaoBin> findById(Integer id)
	{
		return vooCordenadaAcaoBinRepository.findById(id);
	}

	@Override
	public void delete(VooCordenadaAcaoBin entity)
	{
		vooCordenadaAcaoBinRepository.delete(entity);
	}

	@Override
	public List<VooCordenadaAcaoBin> findAll(Integer tenantId)
	{
		return vooCordenadaAcaoBinRepository.findAll();
	}

	@Override
	public List<VooCordenadaAcaoBin> findByTenantId(Integer tenantId)
	{
		return null;
	}
}
