import './App.css';
import { StartPage } from './pages/StartPage';
import { ChakraProvider } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Wrapper } from './components/Wrapper';
import SymbolList from './components/SymbolList';

function App() {
  return (
    
    <div className="App">
        <ChakraProvider>
          <BrowserRouter>
          <Wrapper heading='Currency Checker App'>
            <SymbolList/>
            <Routes>
              <Route path="/" element={<StartPage />}></Route>
            </Routes>    
            </Wrapper>
          </BrowserRouter>
        </ChakraProvider>
    </div>

  );
}

export default App;
