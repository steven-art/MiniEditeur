package fr.istic.sTanguy.Meth.TP.Test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.istic.sTanguy.Meth.TP.Interface.Engine;
import fr.istic.sTanguy.Meth.TP.Interface.Selection;
import fr.istic.sTanguy.Meth.TP.classe.EngineImplement;
import fr.istic.sTanguy.Meth.TP.classe.SelectionImplementation;
import fr.istic.sTanguy.Meth.TP.exception.VideException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TestEngine {
	//variables
	EngineImplement page;

	//methode
	private void insertion(String str) {
		int index = 0;

		while (index<str.length()) {
			page.insert(str.charAt(index));
			index++;
		}
	}

	//test
	@BeforeEach
	void setUp() {
		page = new EngineImplement();
	}

	@Test
	@DisplayName("know the buffer in empty")
	void testbuffer1() {
		assertEquals("the string must be Empty ","",page.getBufferContents());
	}

	@Test
	@DisplayName("buffer contains selection if buffer is empty")
	void testBuffer2 () {
		page.getSelection().setMarker();
		assertEquals("the cursor is in pisition 0",0, page.getSelection().getCursorPosition());
		assertEquals("the market is not used",0, page.getSelection().getMarkerPosition());
	}
	@Test
	@DisplayName("buffer contains many caratere")
	void testBuffer3 () {
		insertion("Ce siècle avait deux ans. Rome remplaçait Sparte,\n" + 
				"Déjà Napoléon perçait sous Bonaparte,\n" + 
				"Et du premier consul déjà, par maint endroit,\n" + 
				"Le front de l'empereur brisait le masque étroit.\n" + 
				"Alors dans Besançon, vieille ville espagnole,\n" + 
				"Jeté comme la graine au gré de l'air qui vole,\n" + 
				"Naquit d'un sang breton et lorrain à la fois\n" + 
				"Un enfant sans couleur, sans regard et sans voix ;\n" + 
				"Si débile qu'il fut, ainsi qu'une chimère,\n" + 
				"Abandonné de tous, excepté de sa mère,\n" + 
				"Et que son cou ployé comme un frêle roseau\n" + 
				"Fit faire en même temps sa bière et son berceau.\n" + 
				"Cet enfant que la vie effaçait de son livre,\n" + 
				"Et qui n'avait pas même un lendemain à vivre,\n" + 
				"C'est moi. -\n" + 
				"Je vous dirai peut-être quelque jour\n" + 
				"Quel lait pur, que de soins, que de vœux que d'amour,\n" + 
				"Prodigués pour ma vie en naissant condamnée,\n" + 
				"M'ont fait deux fois l'enfant de ma mère obstinée ;\n" + 
				"Ange qui sur trois fils attachés à ses pas\n" + 
				"Épandait son amour et ne mesurait pas.\n" + 
				"Oh ! l'amour d'une mère ! amour que nul n'oublie !\n" + 
				"Pain merveilleux qu'un dieu partage et multiplie !\n" + 
				"Table toujours servie au paternel foyer !\n" + 
				"Chacun en a sa part et tous l'ont tout entier !\n" + 
				"Je pourrai dire un jour, lorsque la nuit douteuse\n" + 
				"Fera parler les soirs ma vieillesse conteuse,\n" + 
				"Comment ce haut destin de gloire et de terreur\n" + 
				"Qui remuait le monde aux pas de l'empereur,\n" + 
				"Dans son souffle orageux m'emportant sans défense,\n" + 
				"A tous les vents de l'air fit flotter mon enfance.\n" + 
				"Car, lorsque l'aquilon bat ses flots palpitants,\n" + 
				"L'océan convulsif tourmente en même temps\n" + 
				"Le navire à trois ponts qui tonne avec l'orage,\n" + 
				"Et la feuille échappée aux arbres du rivage. ");
		assertEquals("the charactere a in the position 0 ","Ce siècle avait deux ans. Rome remplaçait Sparte,\n" + 
				"Déjà Napoléon perçait sous Bonaparte,\n" + 
				"Et du premier consul déjà, par maint endroit,\n" + 
				"Le front de l'empereur brisait le masque étroit.\n" + 
				"Alors dans Besançon, vieille ville espagnole,\n" + 
				"Jeté comme la graine au gré de l'air qui vole,\n" + 
				"Naquit d'un sang breton et lorrain à la fois\n" + 
				"Un enfant sans couleur, sans regard et sans voix ;\n" + 
				"Si débile qu'il fut, ainsi qu'une chimère,\n" + 
				"Abandonné de tous, excepté de sa mère,\n" + 
				"Et que son cou ployé comme un frêle roseau\n" + 
				"Fit faire en même temps sa bière et son berceau.\n" + 
				"Cet enfant que la vie effaçait de son livre,\n" + 
				"Et qui n'avait pas même un lendemain à vivre,\n" + 
				"C'est moi. -\n" + 
				"Je vous dirai peut-être quelque jour\n" + 
				"Quel lait pur, que de soins, que de vœux que d'amour,\n" + 
				"Prodigués pour ma vie en naissant condamnée,\n" + 
				"M'ont fait deux fois l'enfant de ma mère obstinée ;\n" + 
				"Ange qui sur trois fils attachés à ses pas\n" + 
				"Épandait son amour et ne mesurait pas.\n" + 
				"Oh ! l'amour d'une mère ! amour que nul n'oublie !\n" + 
				"Pain merveilleux qu'un dieu partage et multiplie !\n" + 
				"Table toujours servie au paternel foyer !\n" + 
				"Chacun en a sa part et tous l'ont tout entier !\n" + 
				"Je pourrai dire un jour, lorsque la nuit douteuse\n" + 
				"Fera parler les soirs ma vieillesse conteuse,\n" + 
				"Comment ce haut destin de gloire et de terreur\n" + 
				"Qui remuait le monde aux pas de l'empereur,\n" + 
				"Dans son souffle orageux m'emportant sans défense,\n" + 
				"A tous les vents de l'air fit flotter mon enfance.\n" + 
				"Car, lorsque l'aquilon bat ses flots palpitants,\n" + 
				"L'océan convulsif tourmente en même temps\n" + 
				"Le navire à trois ponts qui tonne avec l'orage,\n" + 
				"Et la feuille échappée aux arbres du rivage. ",page.getBufferContents());
	}


	@Test
	@DisplayName("insertion of charactere in the buffer")
	void testinsert1 () {

		page.insert('a');
		assertEquals("the charactere a in the position 0 ",'a',page.getBufferContents().charAt(0));
	}
	@Test
	@DisplayName("inserttion of charactere in the beginning")
	void testinsert2 () {
		insertion("bonjour");

		assertEquals("o is in de second position",'o',page.getBufferContents().charAt(1));
		assertEquals("r is in de six position",'r',page.getBufferContents().charAt(6));

	}

	@Test
	@DisplayName("insert charactere in middel of the text")
	void testinsert3 () {

		insertion("bonjour");
		page.getSelection().moveCursor(-4);
		page.insert('s');
		assertEquals("s is in de six position",'s',page.getBufferContents().charAt(3));
	}
	@Test
	@DisplayName("insert charactere in a selection")
	void testinsert4 () {
		insertion("bonjour");

		assertEquals("la position du curseur",7,page.getSelection().getCursorPosition());
		page.getSelection().moveCursor(-5);
		assertEquals("la position du curseur",2,page.getSelection().getCursorPosition());
		page.getSelection().movetolast();
		assertEquals("la position du curseur",7,page.getSelection().getCursorPosition());
		page.insert('s');
		assertEquals("la position du curseur",8,page.getSelection().getCursorPosition());
		assertEquals("insert character s",'s',page.getBufferContents().charAt(7));


	}
	@Test
	@DisplayName("insert the first position")
	void testinsert5 () {
		insertion("Hello");

		assertEquals("la position du curseur",5,page.getSelection().getCursorPosition());
		page.getSelection().movetofirst();
		assertEquals("la position du curseur",0,page.getSelection().getCursorPosition());
		page.insert('s');
		assertEquals("la position du curseur",1,page.getSelection().getCursorPosition());
		assertEquals("insert character s",'s',page.getBufferContents().charAt(0));


	}
	@Test
	@DisplayName("insert charactere before the string")
	void testmoveCursor () {
		insertion("bonjour");
		page.getSelection().moveCursor(-8);
		page.insert('s');
		assertEquals("s is in de six position",'s',page.getBufferContents().charAt(0));
	}
	
	@Test
	@DisplayName("move cursor in negative position")
	void testmoveCursor2 () {
		insertion("hello !");
		page.getSelection().moveCursor(-100);
		assertEquals("la position du curseur",0,page.getSelection().getCursorPosition());
		page.insert('s');
		assertEquals("s is in de six position",'s',page.getBufferContents().charAt(0));
	}
	
	@Test
	@DisplayName("move cursor in position before the last position")
	void testmoveCursor3 () {
		insertion("hello !");
		page.getSelection().moveCursor(100);
		assertEquals("la position du curseur",7,page.getSelection().getCursorPosition());
		page.insert('s');
		assertEquals("s is in de six position",'s',page.getBufferContents().charAt(7));
	}
	
	@Test
	@DisplayName("delete a character in the beginning of the string")
	void testdelete1 () throws VideException {
		insertion("bonj");
		page.delete();
		assertEquals("the buffer have bon","bon",page.getBufferContents());
	}
	@Test
	@DisplayName("delete several characters one after the other")
	void testdelete1bis () throws VideException {
		insertion("hello world");
		page.delete();
		page.delete();
		page.delete();
		page.delete();
		assertEquals("the buffer have hello w","hello w",page.getBufferContents());
	}
	@Test
	@DisplayName("delete a character in the middel of the string")
	void testdelete2 () throws VideException {
		insertion("bonj");
		page.getSelection().moveCursor(-1);
		page.delete();
		assertEquals("the buffer have bon","boj",page.getBufferContents());
	}
	@Test
	@DisplayName("delete while the cursor is before the string")
	void testdelete3 () throws VideException {
		insertion("hello");
		page.getSelection().moveCursor(-5);
		page.delete();
		assertEquals("the buffer have hello","hello",page.getBufferContents());

	}
	@Test
	@DisplayName("delete selection of string")
	void testdelete4 () throws VideException {
		insertion("bonjour");
		page.getSelection().moveCursor(-5);
		page.getSelection().setMarker();
		assertEquals("position du marqueur",2, page.getSelection().getMarkerPosition() );

		page.getSelection().movetolast();
		assertEquals("position du cursor",7, page.getSelection().getCursorPosition() );
		page.delete();
		assertEquals("the buffer is empty","bo",page.getBufferContents());

	}

	@Test
	@DisplayName("delete in pageEcriture which empty")
	void testdelete5 () throws VideException {

		page.delete();

		assertThrows(VideException.class,() ->page.delete());

	}

	@Test
	@DisplayName("testing if the selection is empty")
	void testgetselection1 () {
		insertion("bonj");
		page.getSelection().setMarker();
		assertEquals("the cursor is in position 0",0, page.getSelection().getLenght());

	}
	@Test
	@DisplayName("test of move to first")
	void testgetselection2 () {
		insertion("bonj");
		page.getSelection().movetofirst();
		assertEquals("the cursor is in position 0",0, page.getSelection().getCursorPosition());
	}

	@Test
	@DisplayName("test")
	void testgetselection3 () {
		insertion("hello");
		page.getSelection().moveCursor(-15);
		page.getSelection().setMarker();
		page.getSelection().moveCursor(12);
		assertEquals("the cursor is in position 5",5, page.getSelection().getCursorPosition());
		assertEquals("the maker is in position 0",0, page.getSelection().getMarkerPosition());
	}

	@Test
	@DisplayName("copy one charatere")
	void testcopy1 () {
		insertion("bonj");
		page.getSelection().moveCursor(-1);
		page.getSelection().setMarker();
		page.getSelection().movetolast();
		page.copy();
		assertEquals("the clipboard content","j",page.getClipboardContents());

	}

	@Test
	@DisplayName("copy the selection ")
	void testcopy2 () {
		insertion("bonjour");
		page.getSelection().moveCursor(-5);
		page.getSelection().setMarker();
		page.getSelection().moveCursor(+4);
		page.copy();
		assertEquals("the clipboard content","njou",page.getClipboardContents());

	}

	@Test
	@DisplayName("copy the selection is empty")
	void testcopy3 () {
		insertion("bonjour");
		page.getSelection().moveCursor(-5);
		page.getSelection().setMarker();
		page.getSelection().moveCursor(+4);
		page.copy();
		page.getSelection().movetolast();
		page.getSelection().setMarker();
		page.copy();
		assertEquals("the clipboard content","",page.getClipboardContents());

	}
	@Test
	@DisplayName("copy in the beginning on the string")
	void testcopy4 () {
		insertion("bonjour");
		page.getSelection().moveCursor(-7);
		page.getSelection().setMarker();
		page.getSelection().moveCursor(+4);
		page.copy();
		assertEquals("the clipboard content","bonj",page.getClipboardContents());
		page.getSelection().movetolast();
		page.getSelection().setMarker();
		page.copy();
		assertEquals("the clipboard content","",page.getClipboardContents());

	}



	@Test
	@DisplayName("copy and cut all the selection in the clipboard 1 ")
	void testcut () {
		insertion("bonjour");
		page.getSelection().moveCursor(-7);
		page.getSelection().setMarker();
		page.getSelection().movetolast();
		page.cut();
		assertEquals("the Clipboard contents","bonjour",page.getClipboardContents());

		assertEquals("the buffer contents","",page.getBufferContents());
		assertEquals("the cursor is in position 0",0, page.getSelection().getCursorPosition());
	}

	@Test
	@DisplayName("copy and cut all the selection in the clipboard 2 ")
	void testcut2 () {
		insertion("bonjour");
		page.getSelection().moveCursor(-4);
		page.getSelection().setMarker();
		page.getSelection().movetolast();
		page.cut();
		assertEquals("the clipboard content","jour",page.getClipboardContents());

		assertEquals("the buffer contents","bon",page.getBufferContents());
		assertEquals("the cursor is in position 3",3, page.getSelection().getCursorPosition());
	}

	@Test
	@DisplayName("copy and cut all the selection empty in the clipboard ")
	void testcut3 () {
		insertion("bonjour");
		page.getSelection().moveCursor(-4);
		page.getSelection().setMarker();
		
		page.cut();

		assertEquals("the clipboard contents","",page.getClipboardContents());
		assertEquals("the buffer contents","bonjour",page.getBufferContents());
		assertEquals("the cursor is in position 3",3, page.getSelection().getCursorPosition());
	}

	@Test
	@DisplayName("paste the contents presente in clipboard in location of the cursor  ")
	void testpaste1 () {
		insertion("bonjour toi");
		page.getSelection().moveCursor(-4);
		page.getSelection().setMarker();
		page.getSelection().movetolast();
		page.copy();
		page.getSelection().movetofirst();
		page.paste();

		assertEquals("the clipboard content"," toi",page.getClipboardContents());
		assertEquals("the buffer contents"," toibonjour toi",page.getBufferContents());
		assertEquals("the cursor is in position 7",7, page.getSelection().getCursorPosition());
	}



	@Test
	@DisplayName("paste the contents presente in clipboard in location of the cursor  ")
	void testpaste2 () {
		insertion("bonjour toi");
		page.getSelection().moveCursor(-4);
		page.getSelection().setMarker();
		page.getSelection().movetolast();
		page.copy();
		page.getSelection().movetofirst();
		page.getSelection().setMarker();
		page.getSelection().moveCursor(2);
		page.paste();
		assertEquals("clipboard content"," toi",page.getClipboardContents());
		
		assertEquals("the buffer contents","nj toiour toi",page.getBufferContents());
		assertEquals("the cursor is in position 4",4, page.getSelection().getCursorPosition());
	}
	
	@Test
	@DisplayName("paste the contents presente in clipboard in location of the selection  ")
	void testpaste3 () {
		insertion("hello world");
		page.getSelection().moveCursor(-5);
		page.getSelection().setMarker();
		page.getSelection().movetolast();
		page.copy();
		page.getSelection().movetofirst();
		page.getSelection().setMarker();
		page.getSelection().moveCursor(5);
		
		page.paste();
		assertEquals("clipboard content","world",page.getClipboardContents());
		
		assertEquals("the buffer contents"," worlworldd",page.getBufferContents());
		assertEquals("the cursor is in position 10",10, page.getSelection().getCursorPosition());
	}

}

