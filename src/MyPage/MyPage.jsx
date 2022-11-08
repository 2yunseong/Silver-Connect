import React, { useEffect, useState } from 'react';
import { myPageData } from '../util/dummy';

const MyPage = () => {
  const [userData, setUserData] = useState({});

  useEffect(() => {
    setUserData(() => myPageData);
  }, []);

  return (
    <div className='place-self-center w-30 text-center'>
      <div className='header flex'>
        <h2>마이 페이지</h2>
        <button className='b-4'>변경</button>
      </div>
      <div className='name-element flex'>
        <div className='w-1/3'>이름</div>
        <div>{userData.name}</div>
      </div>
      <div className='phone-element flex'>
        <div className='w-1/3'>연락처</div>
        <div>{userData.phone}</div>
      </div>
      <div className='email-element flex'>
        <div className='w-1/3'>이메일</div>
        <div>{userData.email}</div>
      </div>
    </div>
  );
};

export default MyPage;
