import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'
import TransactionsContainer from './transactions/components/TransactionsContainer';

function App() {
  return (
      <div className="App">
        <TransactionsContainer/>
      </div>
  );
}

export default App;
