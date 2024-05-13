import './App.css';
import { StartPage } from './pages/StartPage';
import { ChakraProvider } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Wrapper } from './components/Wrapper';
import Navbar from './components/Navbar';

function App() {
  return (
    
    <div className="App">
        <ChakraProvider>
          <BrowserRouter>
          <Wrapper heading='Currency Checker App'>
            <Navbar/>
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
