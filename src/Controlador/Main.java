package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import Vista._00_Login;
import Vista._01_Registro;
import Vista._02_OlvidoPwd;
import Vista._03_PantallaUsrAdmDenuncia;
import Vista._04_AlertaDenuncia;
import Vista._05_EstadoDenuncia;
import Vista._06_DenunciasFavUsrAdm;
import Vista._07_PantallaAdmin;
import Vista._08_AjustesUsrAdm;
import Vista._09_CambiarPwd;

public class Main {
	public static void main(String[] args) {
		Controlador miControlador = new Controlador();
		Modelo miModelo = new Modelo();
		Vista[] misVistas = new Vista[10];
		
		misVistas[0] = new _00_Login();
		misVistas[1] = new _01_Registro();
		misVistas[2] = new _02_OlvidoPwd();
		misVistas[3] = new _03_PantallaUsrAdmDenuncia();		
		misVistas[4] = new _04_AlertaDenuncia();
		misVistas[5] = new _05_EstadoDenuncia();
		misVistas[6] = new _06_DenunciasFavUsrAdm();
		misVistas[7] = new _07_PantallaAdmin();
		misVistas[8] = new _08_AjustesUsrAdm();
		misVistas[9] = new _09_CambiarPwd();
		

		miControlador.setModelo(miModelo);
		miControlador.setVista(misVistas);
		miModelo.setVista(misVistas);
		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}
	}
}
