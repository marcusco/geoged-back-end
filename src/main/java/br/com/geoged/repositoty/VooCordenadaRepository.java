package br.com.geoged.repositoty;

import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.dto.VooCordenadaAcaoMapaDTO;
import br.com.geoged.entity.VooCordenada;


public interface VooCordenadaRepository extends JpaRepository<VooCordenada, Integer>
{
	@Query("select e from VooCordenada e where e.tenant_id = :tenant_id and e.dataRegistro = :dataRegistro and e.voo.id = :idVoo and e.latitude = :latitude and e.longitude = :longitude and e.altitude = :altitude")
	public VooCordenada findByTenantIAndAndIdVooAndDataRegistroAndLatitudeAndLongitudeAndAltitude(@Param("tenant_id") Integer tenant_id, @Param("idVoo") Integer idVoo, @Param("dataRegistro") Calendar dataRegistro, @Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("altitude") Double altitude);

	@Query("select e from VooCordenada e where e.tenant_id = :tenant_id and e.voo.id = :idVoo and e.dataRegistro = :dataRegistro")
	public VooCordenada findByTenantIAndAndIdVooAndDataRegistro(@Param("tenant_id") Integer tenant_id, @Param("idVoo") Integer idVoo, @Param("dataRegistro") Calendar dataRegistro);
		
	@Query(value = "select c.idVoo, c.id as idCordenada, a.id as idAcao, c.latitude, c.longitude from geoged.VooCordenada c left join geoged.VooCordenadaAcao a on(c.id = a.idVooCordenada) where c.idVoo = :idVoo", nativeQuery = true)
	public List<VooCordenadaAcaoMapaDTO> findVooCordenadaAcaoDTOByIdVoo(@Param("idVoo") Integer idVoo);

}
