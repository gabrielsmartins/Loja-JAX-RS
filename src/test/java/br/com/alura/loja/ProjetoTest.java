package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Projeto;
import br.com.alura.loja.server.Servidor;
import junit.framework.Assert;

public class ProjetoTest {
	private HttpServer server;

	@Before
	public void startaServidor() {
		this.server = Servidor.inicializaServidor();
	}

	@After
	public void mataServidor() {
		server.stop();
	}
	
	@Test
    public void testaQueAConexaoComOServidorFuncionaNoPathDeProjetos() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
        Assert.assertTrue(projeto.getNome().contains("Minha loja"));
    }
	
    @Test
    public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
        Assert.assertEquals("Minha loja", projeto.getNome());
    }
    
    @Test
    public void testaQueBuscarUmProjetoTrasUmProjeto() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
        Assert.assertEquals("Minha loja", projeto.getNome());
    }
}