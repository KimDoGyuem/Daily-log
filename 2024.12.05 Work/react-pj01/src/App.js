import './App.css';
import axios from 'axios';
import React, { useState, useEffect} from 'react';
import Character from './Character.js';
import CharacterArea from './CharacterArea.js';

function App() {

    const params = new URLSearchParams(window.location.search);
    let id = params.get("id");

    const [name, setName] = useState('');
    const [character, setCharacter] = useState([]);
    const [party, setParty] = useState([]);

    useEffect(() => {
        if (id !== '') {
            getMyList();
            getMyParty();
        }
    }, []);

    function searchCharacter(event) {
        event.preventDefault();
        console.log(`검색한 이름 : ${name}`);
        if (id === '') {
            axios.get(`http://localhost:8080/spring/mh/characterSearch?name=${name}`)
                .then(response => {
                    console.log(response.data);
                    setCharacter([...character, response.data]);
                })
                .catch(error => {
                    console.error('에러임', error);
                })
        } else {
            axios.get(`http://localhost:8080/spring/mh/loginCharacterSearch?name=${name}&id=${id}`)
                .then(response => {
                    console.log(response.data);
                    setCharacter([...character, response.data]);
                })
                .catch(error => {
                    console.error('에러임', error);
                })
        }
    }

    function getMyList(){
        axios.get(`http://localhost:8080/spring/mh/characterList?id=${id}`)
            .then(response => {
                setCharacter(response.data);
            })
            .catch(error => {
                console.error('에러임', error);
            })
        };

    function listReset() {
        if (id !== '') {
            axios.get(`http://localhost:8080/spring/mh/listReset?id=${id}`)
                .then(() => {
                    getMyList();
                })
                .catch(error => {
                    console.error('에러임', error);
                })
        } else {
            setCharacter([]);
        }
    }

    function addParty(name, cName, level, oPower, mPower, aDamage, critical, balance, urAttacks) {
        if (id === '') {
            setParty([...party, {
                character_name: name, class_name: cName, level: level, offensive_power: oPower, magic_power: mPower,
                additional_damage: aDamage, critical: critical, balance: balance, unrestricting_Attacks: urAttacks
            }]);
        } else {
            var p = { id: id, character_name: name };
            idAddParty(p)
        }
    }

    function idAddParty(p) {
        axios.post('http://localhost:8080/spring/mh/idAddParty', p)
            .then(() => {
                getMyParty();
            })
            .catch(error => {
                console.error('에러임', error);
            })
    }

    function getMyParty(){
        axios.get(`http://localhost:8080/spring/mh/getMyParty?id=${id}&no=1`)
            .then(response => {
                setParty(response.data);
            })
            .catch(error => {
                console.error('에러임', error);
            })
    };

    function removeParty(characterName){
        if(id===''){
            setParty(party.filter(a => a.character_name !== characterName));
        }else{
            axios.post('http://localhost:8080/spring/mh/idRemoveParty', {id: id, character_name: characterName})
            .then(() => {
                getMyParty();
            })
            .catch(error => {
                console.error('에러임', error);
            })
        }
    }

    return (
        <div>
            <h3>파티구성</h3>
            <CharacterArea>
                {party.map((c, index) => (
                    <Character key={index} characterName={c.character_name} characterClass={c.class_name} level={c.level} oPower={c.offensive_power} mPower={c.magic_power}
                        anDamage={c.additional_damage} critical={c.critical} balance={c.balance} urAttacks={c.unrestricting_Attacks} 
                        click={() => removeParty(c.character_name)}/>
                ))}
            </CharacterArea>

            <h3>캐릭터 검색</h3>
            <button onClick={listReset}>리스트 초기화</button>
            <CharacterArea>
                {character.map((c, index) => (
                    <Character key={index} characterName={c.character_name} characterClass={c.class_name} level={c.level} oPower={c.offensive_power} mPower={c.magic_power}
                        anDamage={c.additional_damage} critical={c.critical} balance={c.balance} urAttacks={c.unrestricting_Attacks}
                        click={() => addParty(c.character_name, c.class_name, c.level, c.offensive_power, c.magic_power, c.additional_damage, c.critical, c.balance, c.unrestricting_Attacks)} />
                ))}
            </CharacterArea>
            <br></br>
            <form onSubmit={searchCharacter}>
                <input value={name} onChange={(e) => setName(e.target.value)} placeholder='닉네임을 입력하세요' />
                <button type='submit'>검색</button>
            </form>
            <br></br>
            <a href='http://localhost:8080/spring/'>홈으로</a>

        </div>
    );
}
export default App;