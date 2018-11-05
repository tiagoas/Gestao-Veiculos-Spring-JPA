package br.una.veiculos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.una.veiculos.model.AnimalEstimacao;
import br.una.veiculos.model.Cidade;
import br.una.veiculos.model.Condominio;
import br.una.veiculos.model.Endereco;
import br.una.veiculos.model.Estado;
import br.una.veiculos.model.Morador;
import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.AnimalEstimacaoRepository;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.repository.CondominioRepository;
import br.una.veiculos.repository.EnderecoRepository;
import br.una.veiculos.repository.EstadoRepository;
import br.una.veiculos.repository.MoradorRepository;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;
import br.una.veiculos.repository.VeiculoRepository;

@SpringBootApplication
public class GestaoVeiculosApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private AnimalEstimacaoRepository animaisRepo;
	@Autowired
	private CondominioRepository condominiosRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private MoradorRepository moradorRepo;
	@Autowired
	private UnidadeHabitacionalRepository unidadeHabRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(GestaoVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(1L, "MG");
		Estado est2 = new Estado(2L, "GO");
		estadoRepo.saveAll(Arrays.asList(est1, est2));
		
		Cidade c1 = new Cidade(1L, "Uberlândia",       est1);
		c1 = cidadeRepo.save(c1);
		Cidade c2 = new Cidade(2L, "Araguari",         est1);
		Cidade c3 = new Cidade(3L, "Belo Horizonte",   est1);
		Cidade c4 = new Cidade(4L, "Catalão",          est2);
		Cidade c5 = new Cidade(5L, "Caldas Novas",     est2);
		
		cidadeRepo.saveAll(Arrays.asList( c2, c3, c4, c5));
		
		Endereco end1 = new Endereco(1L, "Rua joão naves de avila", 300, "lado", "Centro", "38-408-566", c1);
		end1 = enderecoRepo.save(end1);
		
		Condominio cond1 = new Condominio (1L, "Morada da Colina", false, end1);
		condominiosRepo.save(cond1);
		
		Condominio cond2 = new Condominio (2L, "Porto seguro", false, end1);
		condominiosRepo.save(cond2);
		
		String t1 =  "34 9988-7679";
		String t2 =  "35 43576-8886";
		String t3 =  "40 0800 878 098";
		
		
		List<String> listaTelefones = new ArrayList<String>();
		listaTelefones.add(t1);
		listaTelefones.add(t2);
		listaTelefones.add(t3);
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false);
		
		Date data = df.parse("09/09/1987");
		
		UnidadeHabitacional un1 =  new UnidadeHabitacional(1L, "Apartamento 4f", "9z", true);
		unidadeHabRepo.save(un1);
		
		List<UnidadeHabitacional> unidades = new ArrayList<>();
		unidades.add(un1);

		Morador m2 = new Morador(2L, "bruno",    "tiu", false, false, "eduardo", "107.467.464-56", data,  listaTelefones, cond1,  unidades);
		m2 = moradorRepo.save(m2);
		
		Morador m3 = new Morador(3L, "rafael", "vkekjk4k0", false, false, "´Poliana", "079.556.464-09", data,  listaTelefones, cond2,  unidades);
		m3 = moradorRepo.save(m3);
		
			
		
		Veiculo vei1 = new Veiculo(1L, "MHJ-9060", "FIESTA", "FORD", "2019", m3);
		Veiculo vei2 = new Veiculo(2L, "OTY-7671", "CORSA", "CHEVROLET",    "1995", m2);
		veiculoRepo.saveAll(Arrays.asList(vei1, vei2));
				
        df.setLenient (false);		
		data = df.parse("03/09/2020");
		
		AnimalEstimacao an1 = new AnimalEstimacao(1L, "Dog", "leçi", "GRANDE",  data, m2);
		
		df.setLenient (false);		
		data = df.parse("12/04/2018");
	    AnimalEstimacao an2 = new AnimalEstimacao(2L, "ROTI", "PINGO","PEQUENO", data, m3 );
		animaisRepo.saveAll(Arrays.asList(an1, an2));
		
			
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}