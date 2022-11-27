import { Route, BrowserRouter, Routes } from 'react-router-dom';
import Navbar from './Navbar/Navbar';
import Homepage from './Homepage/Homepage';
import List from './HouseHolds/List';
import MyPage from './MyPage/MyPage';
import Select from './HouseHolds/Select';
import SignUp from './SignUp/SignUp';
import Login from './Login/Login';
import { useState } from 'react';

function App() {
  const [isLogin, setIsLogin] = useState(false);
  return (
    <BrowserRouter>
      <Navbar isLogin={isLogin} />
      <Routes>
        <Route path='/' element={<Homepage />} />
        <Route path='/homepage' element={<Homepage />} />
        <Route path='/household' element={<List />} />
        <Route path='/household/:id/' element={<Select />} />
        <Route path='/mypage' element={<MyPage />} />
        <Route path='/signup' element={<SignUp />} />
        <Route path='/login' element={<Login setIsLogin={setIsLogin} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
