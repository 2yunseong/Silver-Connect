import { Route, BrowserRouter, Routes } from 'react-router-dom';
import Navbar from './Navbar/Navbar';
import Homepage from './Homepage/Homepage';
import List from './HouseHolds/List';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path='/' element={<Homepage />} />
        <Route path='/homepage' element={<Homepage />} />
        <Route path='/household' element={<List />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
