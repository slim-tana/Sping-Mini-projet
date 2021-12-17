package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		List<Stock> stock = stockRepository.findAll();
		return stock;
	}


	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		stockRepository.save(s);
		return s;
	}


	@Override
	public Stock updateStock(Stock u) {
		// TODO Auto-generated method stub
		return stockRepository.save(u);
	}


	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		Stock stock = stockRepository.findById(id).orElse(null);
		return stock;
	}

}
