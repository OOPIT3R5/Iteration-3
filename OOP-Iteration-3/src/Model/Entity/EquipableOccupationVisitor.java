package Model.Entity;

public class EquipableOccupationVisitor {
	public void visit(Summoner smnr){
		/*Don't understand why we're doing a visitor pattern. You already know which specific avatar you're checking for how to handle if a weapon item is equipable or unequipable and an avatar only has one occupation state durring its lifetime. So why are we using the visitor pattern? It's not a hierercy of occupations we're checking. At this rate we would have "summonerEquipableCheck" which would return true for summoner and return warning messages for the other two, "sneakEquipableCheck" and "smasherEquipableCheck" Why not just encapsulate this check directly in the items by having a "SummonerItem" interface for summoner weapons, tomes, etc. and so on and so forth?*/
	}
	public void visit(Smasher smshr){
		
	}
	public void visit(Sneak snk){
		
	}
}