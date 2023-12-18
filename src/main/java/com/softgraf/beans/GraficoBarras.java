package com.softgraf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.title.Title;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GraficoBarras implements Serializable {
	private static final long serialVersionUID = -6740981731169841913L;
	private BarChartModel barModel;
	
	@PostConstruct
	public void init() {
		// https://www.primefaces.org/showcase/ui/chartjs/bar/bar.xhtml
		
		// labels de cada barra
		List<String> meses = new ArrayList<>();
		meses.add("Janeiro");
		meses.add("Fevereiro");
		meses.add("Março");
		meses.add("Abril");
		meses.add("Maio");
		meses.add("Junho");
		meses.add("Julho");
		meses.add("Agosto");
		
		// valor de cada barra
		List<Number> vendas = new ArrayList<>();
		vendas.add(65);
		vendas.add(59);
		vendas.add(80);
		vendas.add(81);
		vendas.add(56);
		vendas.add(55);
		vendas.add(40);
		vendas.add(77);
		
		// cor de cada barra
		List<String> cores = new ArrayList<String>();
		cores.add("rgba(255,  99, 132, 0.5)");
		cores.add("rgba(255, 159,  64, 0.5)");
		cores.add("rgba(255, 205,  86, 0.5)");
		cores.add("rgba( 75, 192, 192, 0.5)");
		cores.add("rgba( 54, 162, 235, 0.5)");
		cores.add("rgba(153, 102, 255, 0.5)");
		cores.add("rgba(201, 203, 207, 0.5)");
		cores.add("rgba(135, 206, 250, 0.5)");
		
		// objeto principal: representa todo o gráfico de barras
		barModel = new BarChartModel();
		// são os dados gerais do gráfico
		ChartData dados = new ChartData();
		barModel.setData(dados);
		
		// titulo geral do gráfico de barras
		Title titulo = new Title();
		titulo.setText("Vendas 2023");
		titulo.setDisplay(true);
		
		BarChartOptions opcoes = new BarChartOptions();
		opcoes.setTitle(titulo);
		opcoes.setAnimation(new Animation());
		barModel.setOptions(opcoes);
		
		// representa o conjunto de dados de cada barra
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("livros vendidos no mês");  // legenda
		barDataSet.setData(vendas);
		barDataSet.setBackgroundColor(cores);
		
		dados.setLabels(meses);
		dados.addChartDataSet(barDataSet);	
	}
	
	
	public BarChartModel getBarModel() {
		return barModel;
	}
	
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
}
