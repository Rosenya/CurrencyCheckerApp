import './App.css';
import { StartPage } from './pages/StartPage';
import { ChakraProvider } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import SymbolSelect from './components/SymbolSelect';

function App() {
  return (
    
    <div className="App">
        <ChakraProvider>
          <BrowserRouter>

            <SymbolSelect/>
            <Routes>
              <Route path="/" element={<StartPage />}></Route>
            </Routes>    

          </BrowserRouter>
        </ChakraProvider>
    </div>

  );
}

export default App;
