package br.com.geoged.repositoty;

import java.util.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.VooCordenada;


public interface VooCordenadaRepository extends JpaRepository<VooCordenada, Integer>
{
	@Query("select e from VooCordenada e where e.tenant_id = :tenant_id and e.dataRegistro = :dataRegistro and e.voo.id = :idVoo and e.latitude = :latitude and e.longitude = :longitude and e.altitude = :altitude")
	public VooCordenada findByTenantIAndAndIdVooAndDataRegistroAndLatitudeAndLongitudeAndAltitude(@Param("tenant_id") Integer tenant_id, @Param("idVoo") Integer idVoo, @Param("dataRegistro") Calendar dataRegistro, @Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("altitude") Double altitude);
}
