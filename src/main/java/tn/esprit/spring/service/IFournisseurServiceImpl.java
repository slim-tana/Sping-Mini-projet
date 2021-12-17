package tn.esprit.spring.service;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;

import javax.mail.Message;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Service
@Slf4j
public class IFournisseurServiceImpl implements IFournisseur {
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
		return fournisseurs;
	}
    @CrossOrigin(origins="http://localhost:4200")
	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur u,long  i) {
		Fournisseur f=fournisseurRepository.findById(i).get();
		f.setAdresse(u.getAdresse());
		f.setEmail(u.getEmail());
		f.setFirstName(u.getFirstName());
		f.setLastName(u.getLastName());
		f.setPhone(u.getPhone());
		
			
		
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);
		return fournisseur;	// TODO Auto-generated method stub
	}
	@Override
	public List<Object[]> nombreProduitsFournisseur() {
		// TODO Auto-generated method stub
		return fournisseurRepository.GetNbProductsbySupplier();
	}
	@Override
	public List<Object[]> nombreFournisseurparpays() {
		// TODO Auto-generated method stub
		return fournisseurRepository.countsuppliersbycountry();
	}
	 public void sendmail(Fournisseur c)  
	    {
	    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    	mailSender.setHost("smtp.mailtrap.io");
	    	mailSender.setPort(2525);
	    	mailSender.setUsername("e6572d8cbed75c");
	    	mailSender.setPassword("7bdc918d78c891");
	    	 
	    	Properties properties = new Properties();
	    	properties.setProperty("mail.smtp.auth", "true");
	    	properties.setProperty("mail.smtp.starttls.enable", "true");
	    	 
	    	mailSender.setJavaMailProperties(properties);
	    	String from = mailSender.getUsername();
	    	String to = "selimtana@gmail.com";
	    	 
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	 
	    	message.setFrom(from);    	
	    	message.setTo(to);
	    	message.setText("nb produits="+c.getSp().stream().count());
	    	message.setSubject("nb produits="+c.getSp().stream().count());
	    	
	    		mailSender.send(message);
	    	
	    }
	 
	 @Override
		public List<Fournisseur>  getFournisseurByName(String msg) {
			// TODO Auto-generated method stub
			return fournisseurRepository.getFournisseurByName(msg);
		}
	}


	

