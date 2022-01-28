package br.com.geoged.repositoty;

import java.util.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.geoged.entity.VooCordenadaAcao;


public interface VooCordenadaAcaoRepository extends JpaRepository<VooCordenadaAcao, Integer>
{
	@Query("select e from VooCordenadaAcao e where e.tenant_id = :tenant_id and e.vooCordenada.id = :idVooCordenada and e.acaoTipo.id =  :idAcaoTipo and e.dataRegistro = :dataRegistro")
	public VooCordenadaAcao findByTenantIAndAIdVooCordenadaAndIdAcaoTipoAndDataRegistro(@Param("tenant_id") Integer tenant_id, @Param("idVooCordenada") Integer idVooCordenada, @Param("idAcaoTipo") Integer idAcaoTipo, @Param("dataRegistro") Calendar dataRegistro);
	
	@Query("select e from VooCordenadaAcao e where e.id = :id")
	public VooCordenadaAcao findByIdVooCordenadaAcao(@Param("id") Integer id);
	
}
