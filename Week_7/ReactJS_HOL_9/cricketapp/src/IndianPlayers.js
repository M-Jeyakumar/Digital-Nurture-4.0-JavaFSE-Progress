import React from 'react';

const IndianTeam = ["Sachin1", "Dhoni2", "Virat3", "Rohit4", "Yuvraj5", "Raina6"];

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
const AllIndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

export function OddPlayers() {
    const [first, , third, , fifth] = IndianTeam;
    return (
        <div>
            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>
        </div>
    );
}

export function EvenPlayers() {
    const [, second, , fourth, , sixth] = IndianTeam;
    return (
        <div>
            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>
        </div>
    );
}

export function ListofIndianPlayers() {
    return (
        <ul>
            {AllIndianPlayers.map((player, index) => (
                <li key={index}>Mr. {player}</li>
            ))}
        </ul>
    );
}