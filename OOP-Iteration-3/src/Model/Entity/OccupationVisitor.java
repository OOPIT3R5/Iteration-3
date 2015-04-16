package Model.Entity;

public interface OccupationVisitor {
	public void visit(Summoner smnr);
	public void visit(Smasher smshr);
	public void visit(Sneak snk);
}