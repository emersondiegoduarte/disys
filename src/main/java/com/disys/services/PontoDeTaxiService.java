package com.disys.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.disys.entities.PontoDeTaxi;

@Service
public class PontoDeTaxiService {

	public List<PontoDeTaxi> listaPontoDeTaxi() {
		List<PontoDeTaxi> pontos =  new ArrayList<PontoDeTaxi>();
		try {
			Files.lines(Paths.get("disys.csv")).forEach(line -> {
				String [] linhas = line.split("#");
				PontoDeTaxi ponto =  new PontoDeTaxi();
				ponto.setNomeDoPonto(linhas[0]);
				ponto.setLatitude(linhas[1]);
				ponto.setLongitude(linhas[2]);
				ponto.setDataCadastro(linhas[3]);
				pontos.add(ponto);
			});
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
			FileWriter fw = new FileWriter( Paths.get("disys.csv").toFile(), true );
			BufferedWriter bw = new BufferedWriter( fw );
			bw.newLine();
			bw.write(novaLinha);
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaPontoDeTaxi();
	}

}
