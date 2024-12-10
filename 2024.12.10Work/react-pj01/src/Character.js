import './App.css';

function PhysicalOrMagic(characterClass, oPower, mPower) {
    const magicClasses = ['단아', '이비', '체른', '미울', '아리샤', '테사', '라티야', '헤기'];
    if (magicClasses.includes(characterClass)) {
        return <>마법공격력:{mPower}</>;
    } else {
        return <>공격력:{oPower}</>;
    }
}

function Character({ characterName, characterClass, level, oPower, mPower, anDamage, critical, balance, urAttacks, click }) {
    return (
        <div className={`character ${characterClass}`} onClick={click}>
            <div id='info'>
                이름:{characterName}<br />
                레벨:{level}<br />
                {PhysicalOrMagic(characterClass, oPower, mPower)}<br />
                추가피해:{anDamage}<br />
                크리티컬:{critical}<br />
                밸런스:{balance}<br />
                공해제:{urAttacks}
            </div>
        </div>
    )
}

export default Character;