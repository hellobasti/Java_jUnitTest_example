package starwars.test;

import static org.junit.Assert.*;

import org.junit.Test;

import starwars.constants.FightType;
import starwars.constants.JediRank;
import starwars.factories.FightFactory;
import starwars.interfaces.Fight;
import starwars.models.characters.Jedi;
import starwars.models.characters.Stormtrooper;

public class FightOfDeathStarTest {
	
	private Fight GetNewFightOfDeathStar() {
		return FightFactory.getFight(FightType.Deathstar);
	}

	@Test
	public void StormAgainstJedis_JediWins_IncreaseCountOfJediWins() {
		Fight fightOfDeathStar = GetNewFightOfDeathStar();
		
		Stormtrooper[] stormtroopers = new Stormtrooper[1];
		Jedi[] jedis = new Jedi[5];
		
		for(int i=0; i < stormtroopers.length; i++) {
			stormtroopers[i] = new Stormtrooper("ST123" + i);			
		}
		
		for(int i=0; i < jedis.length; i++) {
			jedis[i] = new Jedi("Obi Wan" + i, "blue", JediRank.JEDI_MASTER);	
		}
		
		fightOfDeathStar.stormAgainstJedi(stormtroopers, jedis);
		int jediScore = fightOfDeathStar.getScores().get("Jedi");
		assertEquals(jediScore, 1);
	}
	
	@Test
	public void StormAgainstJedis_StormWins_IncreaseCountOfStormWins() {
		Fight fightOfDeathStar = GetNewFightOfDeathStar();
		
		Stormtrooper[] stormtroopers = new Stormtrooper[50];
		Jedi[] jedis = new Jedi[5];
		
		for(int i=0; i < stormtroopers.length; i++) {
			stormtroopers[i] = new Stormtrooper("ST123" + i);			
		}
		
		for(int i=0; i < jedis.length; i++) {
			jedis[i] = new Jedi("Obi Wan" + i, "blue", JediRank.JEDI_MASTER);	
		}
		
		fightOfDeathStar.stormAgainstJedi(stormtroopers, jedis);
		int stormtrooperScore = fightOfDeathStar.getScores().get("Stormtrooper");
		assertEquals(stormtrooperScore, 1);
	}
	
	@Test
	public void StormAgainstJedis_ThrowsNullPointerException_BothParameterAreNull() {
		boolean isExceptionThrown = false;
		
		try {
			
			Fight fightOfDeathStar = GetNewFightOfDeathStar();
			
			Stormtrooper[] stormtroopers = null;
			Jedi[] jedis = null;
			
			fightOfDeathStar.stormAgainstJedi(stormtroopers, jedis);
			
		} catch(NullPointerException ex) {			
			isExceptionThrown = true;			
		}
		assertTrue(isExceptionThrown);
	}
	
	@Test
	public void StormAgainstJedis_ThrowsNullPointerException_ParameterJediIsNull() {
		boolean isExceptionThrown = false;
		
		try {
			
			Fight fightOfDeathStar = GetNewFightOfDeathStar();
			
			Stormtrooper[] stormtroopers = new Stormtrooper[1];
			Jedi[] jedis = null;
			
			for(int i=0; i < stormtroopers.length; i++) {
				stormtroopers[i] = new Stormtrooper("ST123" + i);			
			}
			
			fightOfDeathStar.stormAgainstJedi(stormtroopers, jedis);
			
		} catch(NullPointerException ex) {			
			isExceptionThrown = true;			
		}
		assertTrue(isExceptionThrown);
	}
	
	@Test
	public void StormAgainstJedis_ThrowsNullPointerException_ParameterStormIsNull() {
		boolean isExceptionThrown = false;
		
		try {
			
			Fight fightOfDeathStar = GetNewFightOfDeathStar();
			
			Stormtrooper[] stormtroopers = null;
			Jedi[] jedis = new Jedi[5];
			
			for(int i=0; i < jedis.length; i++) {
				jedis[i] = new Jedi("Obi Wan" + i, "blue", JediRank.JEDI_MASTER);	
			}
			
			fightOfDeathStar.stormAgainstJedi(stormtroopers, jedis);
			
		} catch(NullPointerException ex) {			
			isExceptionThrown = true;			
		}
		assertTrue(isExceptionThrown);
	}
	
}
