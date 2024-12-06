import './App.css';
import axios from 'axios';
import React, {useState, useEffect} from 'react';

function Shop({id}){    

    useEffect(()=>{
        if(!id){
            alert('로그인 후 시도해주세요.');
            window.location.href = 'http://localhost:8080/spring/mabi/board';
        }
    },[id])


    return(
        <>
        테스트<br/>
        <a href='http://localhost:8080/spring/'>홈으로</a>
        </>
    );
}

export default Shop;