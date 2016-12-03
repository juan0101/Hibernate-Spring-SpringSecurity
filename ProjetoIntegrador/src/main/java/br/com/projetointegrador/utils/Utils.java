package br.com.projetointegrador.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.projetointegrador.entity.Materia;
import br.com.projetointegrador.entity.Usuario;

public class Utils {
	
	public static Materia getMateria(String nome){
		for(Materia m: Materia.values()){
			if(nome.equals(m.toString())){
				return m;
			}
		}
		return null;
	}
	
	public static List<String> getTodasMaterias(){
		List<String> materias = new ArrayList<String>();
		for(Materia m: Materia.values()){
			materias.add(m.toString());
		}
		return materias;
	}

	public static Usuario getUsuarioLogado(){
		//metodo para pegar o usuario logado
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication(); 
		if(authentication != null){
			Object obj = authentication.getPrincipal();
			if (obj instanceof Usuario){
				return (Usuario) obj;
			}		
		}
		return null;
	}

	public static boolean verificaLetras(String pala){
		String alfa = "abcdefghijklmnopqrstuvxywz";
		for(int i = 0; i < pala.length(); i++){
			if(!alfa.contains(pala.substring(i, i+1)))
				return false;
		}
		return true;
	}

	public static Date strToDate(String dataStr){
		try{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date data = new Date(format.parse(dataStr).getTime());
			return data;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isNumber(String s){
		for (int i = 0; i < s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public static String senhaSha256(String senha){
		try{
//			MessageDigest digs = MessageDigest.getInstance("MD5");
//			digs.update((new String(senha)).getBytes("UTF8"));
//			String senhaCript  = new String(digs.digest());
			MessageDigest md = MessageDigest.getInstance("MD5");
			 
	        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
	 
	        String senhaCript = String.format("%32x", hash);
	        System.out.println(senhaCript);
			return senhaCript;
		}catch (Exception e){
			System.out.println("Erro ao criptografar" + e);
			return "";
		}
	}

	public static String getFormatedDate(Date date){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11))
			return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0         
				// (48 eh a posicao de '0' na tabela ASCII)         
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return(true);
			else return(false);
		} catch (Exception e) {
			return(false);
		}
	}

	/**
	 * Método main usado para testes dos métodos utilizados
	 * @param args
	 */

	public static void main(String[] args) {
		String dataStr = "19/06/1991";
		Date dataRetorno = strToDate(dataStr);
		System.out.println(dataRetorno);
	}
}
