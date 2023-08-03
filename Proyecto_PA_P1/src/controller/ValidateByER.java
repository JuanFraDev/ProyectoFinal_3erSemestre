package controller;

public class ValidateByER {

	public static boolean codigo(String codigo)
	{
		return codigo.matches("^(ST0)[0-9]+$");
	}

	public static boolean emailCorp(String email) {
		return email.matches("^[a-z]+[0-9]?[@](?:adm|sel|sto)(.st.com)$");
	}

	public static boolean password(String pass) {
		if(pass.length() < 8) {
			return false;
		} else {
			return pass.matches("^(?=.*[A-Z])(?=.*[@\\-/a-z0-9])[A-Za-z@\\-/a-z0-9]+$");
		}
	}

	public static boolean validateNames (String name) {
		return name.matches("^([A-ZÁ-Ú][a-zá-ú]+[ ]?){2}$");
	}

	public static boolean validateNombre (String name) {
		return name.matches("^[A-ZÁ-Ú][a-zá-ú]+$");
	}

	public static boolean validateCodigo (String codigo) {
		return codigo.matches("^[0-9]{5}$");
	}

	public static boolean validateCi (String ci) {
		if (!ci.matches("\\d{10}")) {
			return false;
		}

		int provincia = Integer.parseInt(ci.substring(0, 2));
		if (provincia < 1 || provincia > 24) {
			return false;
		}

		int tercerDigito = Integer.parseInt(ci.substring(2, 3));
		if (tercerDigito < 0 || tercerDigito > 5) {
			return false;
		}

		int suma = 0;
		int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
		for (int i = 0; i < coeficientes.length; i++) {
			int digito = Integer.parseInt(ci.substring(i, i + 1));
			int producto = digito * coeficientes[i];
			suma += (producto % 10) + (producto / 10);
		}
		int digitoVerificadorCalculado = 10 - (suma % 10);
		if (digitoVerificadorCalculado != Integer.parseInt(ci.substring(9))) {
			return false;
		}

		return true;
	}

	public static boolean validateEmail(String email) {
		return email.matches("^[a-zA-Z0-9_.-]+[@][a-z]+(.com)$");
	}

	public static boolean validateConvencional(String telefono) {
		return telefono.matches("^(?:02|03|04|05|06|07)[0-9]{7}$");
	}

	public static boolean validateCelular(String telefono) {
		return telefono.matches("^(09)[0-9]{8}$");
	}

	public static boolean validateDireccion(String direccion) {
		return direccion.matches("^[a-zA-Z0-9_ .-]+$");
	}

}
