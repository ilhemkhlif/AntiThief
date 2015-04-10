package com.example.autosms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.util.Log;

public class PredictifData {
	public static PredictifData instance=null;
	
	public Map<String, String> numDevinette=null;
	public Map<String, String> nomQuestion=null;
	
	public static PredictifData getInstance() {
		if(instance==null) {
			instance=new PredictifData();
		}
		return instance;
	}
	
	PredictifData() {
		if(numDevinette==null) {
			numDevinette = new HashMap<String, String>();
		}
		if(nomQuestion==null) {
			nomQuestion = new HashMap<String, String>();
		}
		
		nomQuestion.put("alicia", "Elle est bruyante,\r\nElle n'est pas très marrante\r\nMais elle est aimante\r\nC'est ce qui la rend si charmante\r\nQui est-ce?");
		nomQuestion.put("ada", "Elle es rikiki\r\nElle tricotte comme une mamie\r\nElle cuisine des super biscuits\r\nEt porte plein de couleurs swaggy\r\nQui est-ce?");
		nomQuestion.put("yann", "Fé pas tré zenti\r\nLes maths fé la vi\r\nTout le monde me haï\r\nEt je serai une tête de turc toute ma vie\r\nQui est-ce?");
		nomQuestion.put("rémi", "Tout le monde l'adore\r\nLes filles en redemandent encore\r\nEt le trouvent tellement fort\r\nPlus tard, il sera plein d'or\r\nQui est-ce?");
		nomQuestion.put("robardet", "J'ai les cheveux d'un noir de jais\r\nJe t'ai probablement déjà fait chier\r\nJe ne trouve pas le bon chemin\r\nJe ne suis pas de sexe masculin\r\nQui suis-je?");
		nomQuestion.put("jean", "Je te hais a cause des peigne-culs, des couillons, des putains,\r\nEtrange à mes heures\r\nAnéantis, tu es, dans le fumier d’un champ de bataille,\r\nN’oublie jamais qui je suis\r\nQui suis-je?");
		nomQuestion.put("camille", "Laisser moi me présenter :\r\nJe fais du très bon risotto\r\nSi je pouvais, je mettrai un chapeau\r\nPour éviter d'attirer les taureaux\r\nQui suis-je?");
		nomQuestion.put("alexandre", "Son prénom vient du grec \"repousser\" et \"l'homme, le guerrier, viril\". Son nom voudrait donc dire celui qui protège les hommes et repousse l'ennemi.\r\nQui est-ce?");
		nomQuestion.put("amaury", "Si on rend mon premier, alors on est mort !.\r\nMon deuxième est un liquide essentiel à toute vie\r\nMon troisième est l'aliment principal en Asie\r\nEt mon tout est un prénom masculin d'origine gotique\r\nQui suis-je?");
		nomQuestion.put("justine", "4A 75 73 74 69 6E 65\r\nQui est-ce?");
		nomQuestion.put("moi", "\r\nQui est-ce?");
		nomQuestion.put("gustave", "gmsntdv\r\nQui est-ce?");
		nomQuestion.put("thomas", "Colle mon prenom avec mon nom.\r\nEnleve une lettre.\r\nAnagramme le tout.\r\nCa donne Housemaster.\r\nQui suis-je?");
	}
	
	public String getRandom() {
		Random       random    = new Random();
		List<String> keys      = new ArrayList<String>(nomQuestion.keySet());
		String       randomKey = keys.get( random.nextInt(keys.size()) );
		Log.v("lll", randomKey);
		return randomKey;
	}
	
	
}
