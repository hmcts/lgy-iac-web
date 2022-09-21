/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.util;

// TODO: Auto-generated Javadoc
/**
 * The Class TextGenerator.
 */
public class TextGenerator {

	/** The buff. */
	private static StringBuffer buff = new StringBuffer();

	/** The buff text. */
	private static StringBuffer buffText = new StringBuffer();


	/** The Constant QUESTIONS. */
	public static final String [] QUESTIONS = {
		"Would you eat fish eyes?",
		"Will you marry me?",
		"Would you like to wear a clown outfit?",
		"Will you sing a pop song?",
		"Will you drink this strange liquid I found in the fridge?",
		"Would you leap from an aeroplane with your mother?",
		"Would you run around the block nekkid?",
		"Will you vote Conservative?",
		"Would you sing on XFactor?",
		"Would you eat a rubber chicken?",
		"Would you wash in chip fat?",
		"Would you swim an a bowl of cornflakes?",
		"Would you sleep with a teddy?",
		"Will you get washed this week?",
		"Would you buy a Kylie album?",
		"Would you go on a date with Prince Charles?",
		"Will you throw Jelly at me?",
		"Would you cover yourself in butter?",
		"Will you collect your belly button fluff?",
		"Would you swop your spouse for a packet of mints?",
		"Shall we date?",
		"Would you like to drink raw eggs?",
		"Will you give me all your money?",
		"Would you like to watch QVC for weeks on end?",
		"Will you buy high heels this week?",
		"Would you bail out the banks?",
		"Would you laugh at my jokes?",
		"Will you wear this dress?",
		"Will you comb your hair with a kipper?",
		"Would you put a pumpkin on your head?",
		"Will you drive like a maniac?",
		"Would you like to throw peanuts?",
		"Will you explain Relativity?",
		"Would you like to read a cook book?",
		"Would you be a Bond girl?",
		"Would you trampoline with farmyard animals?",
		"Would you stuff hay down your wellies?",
		"Will you say wibble?",
		"Would you stick spaghetti up your nose?",
		"Would you bark like a dog?"
	};

	/** The Constant ANSWERS. */
	public static final String [] ANSWERS = {
		"Only if it's a Friday.",
		"Yes, I feel all tingly.",
		"No, you should see what it did to Grandpa.",
		"OK - it's my birthday.",
		"Never, that is utterly insane!",
		"Maybe, if you tickle my tummy.",
		"OOO sounds fun!",
		"No - it is against the Jedi code.",
		"I can't, my mum won't let me.",
		"But what would everyone say?",
		"If you take a picture.",
		"Not if it gets on the news.",
		"No it might bring down the government!",
		"Only if you'll do it to",
		"Yes - it might be my only ticket out of here.",
		"Not even if you were the last person alive.",
		"Yeah, I do that every Sunday night anyway.",
		"Of course, its a personal dream of mine.",
		"Yes - but I'll have to shower afterwards.",
		"Hang on let me phone a friend.",
		"Yes - I wish you'd asked sooner.",
		"Wibble",
		"What a silly question.",
		"I would if I could understand it.",
		"No way - you already look daft.",
		"OOOO I might.",
		"Certainly - its what the Queen would want.",
		"I'll do it for my country.",
		"Only because I love rubber chickens.",
		"Yes, or no, maybe.",
		"I will if you'll wear a gas mask",
		"No it makes me break wind.",
		"Yes, but we'd better start running.",
		"Too late I did that yesterday.",
		"Yes - if you have an escape plan.",
		"No way - that'll cause an explosion.",
		"Won't that damage the paintwork?",
		"Yes - if we can also sing teh National Anthem.",
		"Yes - the neighbours are going to join in.",
		"Never - it is an affornt to decency."
	};


	/**
	 * Gets the text.
	 *
	 * @param chars
	 *            the chars
	 * @return the text
	 */
	public static String getText(int chars) {
		buffText.setLength(0);
		while(buffText.length()< chars){
			buffText.append(sentenceGenerator());
		}
		return buffText.toString().substring(0,chars);
	}

	/**
	 * Sentence generator.
	 *
	 * @return the string
	 */
	private static String sentenceGenerator() {
		buff.setLength(0);
		buff.append(QUESTIONS[(int) (Math.random() * 40)]+" ");
		buff.append(ANSWERS[(int) (Math.random() * 40)]+" ");
		return buff.toString();
	}

}
