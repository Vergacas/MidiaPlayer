package br.ufrn.imd.controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import br.ufrn.imd.dao.MusicaDAO;
import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Musica;
import br.ufrn.imd.modelo.Usuario;

/**
 * Classe de controle para TelaMidiaPlay
 * @author jeanv
 *
 */
public class TelaMidiaPlayController implements Initializable{
	
	MusicaDAO bdMusica;
	UsuarioDAO bdUsuario;
	
	private Usuario user;
	private Integer idUser;
	
	/**
	 * atributo Stage
	 */
	private Stage mpStage;
	
	/**
	 * butao que confirma criação da playlist
	 */
    @FXML
    private Button btnCriarPL;
    
    /**
     * botao que chama proxima musica
     */
    @FXML
    private Button btnNextMusic;
    
    /**
     * botao que pausa a musica
     */
    @FXML
    private Button btnPauseMusic;
    
    /**
     * botao que inicia a musica
     */
    @FXML
    private Button btnPlayMusic;
    
    /**
     * botao que reseta a musica
     */
    @FXML
    private Button btnResetMusic;
    
    /**
     * botao que chama a musica anterior
     */
    @FXML
    private Button btnReturnMusic;
    
    /**
     * label que mostra o nome da atual Musica
     */
    @FXML
    private Label lbNomeMusica;
    
    /**
     * ListView q mostra as musica
     */
    @FXML
    private ListView<String> lvMusicas;
    
    /**
     * atributo para guarda musica
     */
    private List<String> musicas = new ArrayList<String>();
    
    /**
     * ObservableList de Musicas
     */
    private ObservableList<String> obMusicas;
    /**
     * ListView de Playlist
     */
    @FXML
    private ListView<?> lvPlayLists;
    
    /**
     * ListView de playList
     */
    @FXML
    private ListView<?> lvPlayLists11;
    
    /**
     * Item de menu addMusica
     */
    @FXML
    private MenuItem mnItemAddMusica;
    
    /**
     * ProgressBar que mostra o progresso da musica
     */
    @FXML
    private ProgressBar somProgressBar;
    
    /**
     * Text com nome Musica
     */
    @FXML
    private Text txtMusica;
    
    /**
     * Text com o nome do usuario
     */
    @FXML
    private Text txtUserNome;
    
    
    private Media media;
    private MediaPlayer mediaPlayer;
    
    private File directory;
    private File[] files;
    
    private ArrayList<File> songs;
    private int songNumber;
    
    private Timer timer;
    private TimerTask task;
    
    private boolean running;
    
    /**
     * metodo carregarMusicas adiciona as musicas no listeView
     */
    public void carregarMusicas() {
    	
    	for(int i = 0; i < bdMusica.getMusicas().size(); i++) {
    		musicas.add(bdMusica.getMusicas().get(i).getNome()); 
    	}
    	obMusicas = FXCollections.observableArrayList(musicas);
    	
    	lvMusicas.setItems(obMusicas);
    }
    
    public void setUsuario() throws FileNotFoundException {
    	bdUsuario = UsuarioDAO.getIstance();
    	user = bdUsuario.getUsuario(idUser);
    }
    
    public void setIdUser(Integer id) {
    	idUser = id;
    	System.out.println(idUser);
    }
    
    /**
     * Método initialize inicia a TelaMidiaPlay
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	System.out.println("iniciando");
    	bdMusica = MusicaDAO.getIsntace();
    	songs = new ArrayList<File>();
    	
    	directory = new File("musicas");
    	
    	files = directory.listFiles();
    	
    	if(files != null) {
    		for(File file : files) {
    			
    			String nomeM  = String.valueOf(file.getName());
    			nomeM = nomeM.substring(0, nomeM.length() - 4);
    			System.out.println(nomeM);
    			Musica m = new Musica();
    			m.setNome(nomeM);
    			m.setAutor("");
    			bdMusica.addMusica(m);
    			songs.add(file);
    		}
    	}
    	media = new Media(songs.get(songNumber).toURI().toString());
    	mediaPlayer = new MediaPlayer(media);
    	carregarMusicas();
    	lbNomeMusica.setText(songs.get(songNumber).getName());
    }
    
    /**
     * Método AdicionarMusica que chama telaCadastroMusica
     * @param ActionEvent
     */
    @FXML
    void AdicionarMusica(ActionEvent event) {
    	
    }
    
    /**
     * metodo que cria uma nova PlayList
     * @param ActionEvent
     */
    @FXML
    void CriarPlayList(ActionEvent event) {

    }
    
    /**
     * metodo que chama a musica anterior
     * @param event
     */
    @FXML
    void backMidia(ActionEvent event) {
    	if(songNumber > 0) {
    		songNumber --;
    		mediaPlayer.stop();
    		
    		if(running) {
    			cancelTimer();
    		}
    		
    		media = new Media(songs.get(songNumber).toURI().toString());
        	mediaPlayer = new MediaPlayer(media);
        	
        	lbNomeMusica.setText(songs.get(songNumber).getName());
        	
    	}else {
    		songNumber = songs.size() - 1;
    		mediaPlayer.stop();
    		
    		if(running) {
    			cancelTimer();
    		}
    		
    		media = new Media(songs.get(songNumber).toURI().toString());
        	mediaPlayer = new MediaPlayer(media);
        	
        	lbNomeMusica.setText(songs.get(songNumber).getName());
    	}
    	playMidia();
    }

    
    /**
     * Métod que pausa a musica
     * @param event
     */
    @FXML
    void pauseMidia(ActionEvent event) {
    	cancelTimer();
    	mediaPlayer.pause();
    }
    
    /**
     * Método que inicia a musica
     */
    @FXML
    void playMidia() {
    	beginTimer();
    	mediaPlayer.play();
    }
    
    /**
     * Metodo que reinicia a musica
     * @param event
     */
    @FXML
    void resetMidia(ActionEvent event) {
    	
    	//mediaPlayer.seek(Duration.ofSeconds(0));
    }
    
    /**
     * metodo que muda o Stage
     * @param mpStage
     */
    public void setMidaStage(Stage mpStage) {
    	this.mpStage = mpStage;
    }
    
    /**
     * Método que chama a proxima musica
     * @param event
     */
    @FXML
    void nextMidia(ActionEvent event) {
    	System.out.println("nextMidia");
    	if(songNumber < songs.size() - 1) {
    		songNumber ++;
    		mediaPlayer.stop();
    		
    		if(running) {
    			cancelTimer();
    		}
    		
    		media = new Media(songs.get(songNumber).toURI().toString());
        	mediaPlayer = new MediaPlayer(media);
        	
        	lbNomeMusica.setText(songs.get(songNumber).getName());
        	
    	}else {
    		songNumber = 0;
    		mediaPlayer.stop();
    		
    		if(running) {
    			cancelTimer();
    		}
    		
    		media = new Media(songs.get(songNumber).toURI().toString());
        	mediaPlayer = new MediaPlayer(media);
        	
        	lbNomeMusica.setText(songs.get(songNumber).getName());
    	}
    	playMidia();
    }
    /**
     * Método que inicializa a progressBar
     */
    public void beginTimer() {
    	timer = new Timer();
    	task  = new TimerTask() {
    		public void run() {
    			running = true;
    			double current = mediaPlayer.getCurrentTime().toSeconds();
    			double end = media.getDuration().toSeconds();
    			somProgressBar.setProgress(current/end);
    			
    			if(current/end == 1) {
    				cancelTimer();
    			}
    		}
    	};
    	
    	timer.scheduleAtFixedRate(task, 100, 1000);
    }
    
    /**
     * Método que cancela a barra de progresso
     */
    public void cancelTimer() {
    	running = false;
    	timer.cancel();
    }
}
