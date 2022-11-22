import { Route, BrowserRouter, Routes } from 'react-router-dom';
import Navbar from './Navbar/Navbar';
import Homepage from './Homepage/Homepage';
import List from './HouseHolds/List';
import MyPage from './MyPage/MyPage';
import Select from './HouseHolds/Select';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path='/' element={<Homepage />} />
        <Route path='/homepage' element={<Homepage />} />
        <Route path='/household' element={<List />} />
        <Route path='/mypage' element={<MyPage />} />
        <Route path='/select' element={<Select />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
