import org.junit.Assert;
import org.junit.Test;

public class ClienteTestes {

    @Test
    public void getNomeDeClientes() {
        Cliente cliente = new Cliente("clienteA", "12345678910", 20);
        Assert.assertEquals("clienteA", cliente.getNome());
    }

    @Test
    public void getCpfDeClientes() {
        Cliente cliente = new Cliente("clienteA", "12345678910", 20);
        Assert.assertEquals("12345678910", cliente.getCpf());
    }

    @Test
    public void getIdadeDeClientes() {
        Cliente cliente = new Cliente("clienteA", "12345678910", 20);
        Assert.assertEquals(20, cliente.getIdade());
    }

    @Test
    public void setNomeDeClientes() {
        Cliente cliente = new Cliente("clienteA", "12345678910", 20);
        cliente.setNome("cliente");
        Assert.assertNotEquals("clienteA", cliente.getNome());
    }

    @Test
    public void setCpfDeClientes() {
        Cliente cliente = new Cliente("clienteA", "12345678910", 20);
        cliente.setCpf("10987654321");
        Assert.assertNotEquals("12345678910", cliente.getCpf());
    }

    @Test
    public void setIdadeDeClientes() {
        Cliente cliente = new Cliente("clienteA", "12345678910", 20);
        cliente.setIdade(10);
        Assert.assertNotEquals(20, cliente.getIdade());
    }
}
