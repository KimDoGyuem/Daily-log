import './App.css';
import axios from 'axios';
import React, { useState, useEffect } from 'react';

function Shop({ id }) {
    var [point, setPoint] = useState(0);

    useEffect(() => {
        if (!id) {
            alert('로그인 후 시도해주세요.');
            window.location.href = 'http://localhost:8080/spring/mabi/board';
        }
        getMyWealth();
    }, [id]);

    function getMyWealth() {
        axios.get(`http://localhost:8080/spring/mabi/myPoint?id=${id}`)
            .then(response => setPoint(response.data))
            .catch(error => console.error('에러임', error));
    }

    function check() {
        axios.get(`http://localhost:8080/spring/mabi/checkLog?id=${id}`)
            .then(
                response => {
                    if (response.data === 1) {
                        alert("출석체크 완료 +100 Point!");
                        checkSuccess();
                    } else {
                        alert("이미 출석체크 하였습니다");
                    }
                })
            .catch(error => console.error('에러임', error));
    }

    function checkSuccess() {
        axios.get(`http://localhost:8080/spring/mabi/check?id=${id}`)
            .then(() => {
                getMyWealth();
            })
            .catch(error => console.error('에러임', error));
    }

    return (
        <>
            <fieldset>
                <legend>나의 포인트</legend>
                <span>{point} 포인트 </span>
                <button onClick={check}>출석체크</button>
            </fieldset>
            <a href='http://localhost:8080/spring/'>홈으로</a>
        </>
    );
}

export default Shop;