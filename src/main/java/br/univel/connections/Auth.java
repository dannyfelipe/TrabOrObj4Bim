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
