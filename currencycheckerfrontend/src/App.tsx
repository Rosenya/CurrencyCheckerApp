import './App.css';
import { StartPage } from './pages/StartPage';
import { ChakraProvider } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Wrapper } from './components/Wrapper';
import SymbolPage from './components/SymbolPage';

function App() {
  return (
    
    <div className="App">
        <ChakraProvider>
          <BrowserRouter>
          <Wrapper heading='Currency Checker App'>
            <SymbolPage/>
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
