package com.disys.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.disys.entities.PontoDeTaxi;

@Service
public class PontoDeTaxiService {

	public List<PontoDeTaxi> listaPontoDeTaxi() {
		List<PontoDeTaxi> pontos =  new ArrayList<PontoDeTaxi>();
		try {
			
			BufferedReader csv =  new BufferedReader(
					new FileReader("disys.csv"));
			String row = null;
			while(( row = csv.readLine()) != null){
				String [] linhas = row.split("#");
				PontoDeTaxi ponto =  new PontoDeTaxi();
				ponto.setNomeDoPonto(linhas[0]);
				ponto.setLatitude(linhas[1]);
				ponto.setLongitude(linhas[2]);
				ponto.setDataCadastro(linhas[3]);
				pontos.add(ponto);
			}
			csv.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pontos;
	}
	
	public List<PontoDeTaxi> inserirPontoDeTaxi(PontoDeTaxi pontoDeTaxi) {
		try {
			String novaLinha = pontoDeTaxi.getNomeDoPonto() + "#" + pontoDeTaxi.getLatitude()
						+ "#" + pontoDeTaxi.getLongitude() + "#" + pontoDeTaxi.getDataCadastro();
			FileWriter fw = new FileWriter("disys.csv", true );
			BufferedWriter bw = new BufferedWriter( fw );
			bw.newLine();
			bw.write(novaLinha);
			fw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaPontoDeTaxi();
	}

}
