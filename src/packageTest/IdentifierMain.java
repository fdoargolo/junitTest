package packageTest;

public class IdentifierMain {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Uso Identifier <string>");
		} else {
			Identifier id = new Identifier();
			if(id.validateIdentifier(args[0])) {
				System.out.println("Valido");
			} else {
				System.out.println("Invalido");
			}
		}
	}

}
