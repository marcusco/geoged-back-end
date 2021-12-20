package br.com.geoged.test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.com.geoged.GeogedAplicationTests;
import br.com.geoged.entity.Usuario;
import br.com.geoged.rest.resource.UsuarioResource;
import br.com.geoged.service.UsuarioService;
import io.restassured.http.ContentType;


@WebMvcTest(UsuarioResource.class)
public class UsuarioResourceTest extends GeogedAplicationTests
{
	@Autowired
	private UsuarioResource	usuarioResource;
	@MockBean
	private UsuarioService	usuarioService;
	//
	@BeforeEach
	public void setUp()
	{
		standaloneSetup(this.usuarioResource);
	}

	@Test
	public void testGetAll() throws Exception
	{
		when(this.usuarioResource.findByTenantId(2)).thenReturn(getList());
		given().accept(ContentType.JSON).when().get("usuario/find_by_tenant_id", 1).then().statusCode(HttpStatus.OK.value());
	}

	private ResponseEntity<List<Usuario>> getList()
	{
		ResponseEntity<List<Usuario>> response = null;
		return response;
	}

	@Test
	public void testSave() throws Exception
	{
		given();
	}
}
