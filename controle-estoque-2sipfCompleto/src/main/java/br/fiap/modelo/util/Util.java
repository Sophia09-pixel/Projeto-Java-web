package br.fiap.modelo.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Util {
	// Número de iterações (pode ser ajustado)
	private static final int ITERATIONS = 10000;
	
	// Tamanho da chave gerada
	private static final int KEY_LENGTH = 256; 
	
	// Algoritmo utilizado
	private static final String ALGORITHM = "PBKDF2WithHmacSHA256"; 

	// Gerar um salt aleatório
	public static byte[] getSalt() {
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}

	// Método para gerar o hash da senha usando PBKDF2
	public static String codificar(String senha, byte[] salt) {
		char[] senhaEmChar = senha.toCharArray();
		PBEKeySpec spec = new PBEKeySpec(senhaEmChar, salt, ITERATIONS, KEY_LENGTH);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
			byte[] hash = skf.generateSecret(spec).getEncoded();
			// Codifica o hash em Base64
			return Base64.getEncoder().encodeToString(hash); 
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException("Erro ao gerar o hash da senha", e);
		}
	}

	// Método para verificar a senha
	public static boolean verificar(String senha, String senhaCodificada, byte[] salt) {
		String newHashedPassword = codificar(senha, salt);
		return newHashedPassword.equals(senhaCodificada);
	}
}
