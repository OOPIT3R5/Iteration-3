package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;

public class Enhance extends SummonerAbility {

	private Entity sourceEntity;
	private Skill skill;
	
	public Enhance(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }
	
	@Override
	public void execute() {
		useMana(sourceEntity);
	}
	
	@Override
	public void cast() {
		final Entity targetEntity = getSourceEntity();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				targetEntity.changeMovementSpeed(2);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				targetEntity.changeMovementSpeed(-2);
			}
		}).start();
	}

	@Override
	public int getRequiredMana() {
		return 15;
	}

	@Override
	protected int scaleMagnitude() {
		return 0;
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}
}