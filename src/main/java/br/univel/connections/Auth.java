package br.univel.connections;

public final class Auth {
	
	public boolean usuarioValido(final String username, final String password) {
		
		/*if ("admin".equals(username) && "123".equals(password)) {
			return true;
		} else {
			return false;
		}*/
		
		return "admin".equals(username) && "123".equals(password);
		
	}

}

/*
 * MD5
 * SELECT MD5('minhasenha');
 * 
 * * nunca utilizar
 * SELECT CRC32('meuteste');
 * 
 * SHA1
 * SELECT SHA1('minhaNovaSenha');
 * 
 * SELECT MD5 + SALT
 * SELECT MD5('adkjsadhkjasd' + minhaSenha + 'ajdalskjdalkjds');
 * */
