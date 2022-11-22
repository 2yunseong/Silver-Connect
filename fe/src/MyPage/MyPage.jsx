import React, { useEffect, useState } from 'react';
import { myPageData } from '../util/dummy';
import LookUp from './Lookup';
import Edit from './Edit';
import './MyPage.css';

const MyPage = () => {
  const [userData, setUserData] = useState({});
  const [isEdit, setIsEdit] = useState(false);

  const onToggle = () => {
    if (isEdit) {
      // edit logic => to server... send data
    }
    setIsEdit(() => !isEdit);
  };

  useEffect(() => {
    setUserData(() => myPageData);
  }, []);

  return (
    <div className='flex flex-col w-3/5 h-2/5 relative top-36 left-80 border text-center pt-5 pb-20 px-20 rounded-lg'>
      <div className='flex justify-between py-5'>
        <h2 className='font-bold text-3xl'>마이 페이지</h2>
        <button
          onClick={onToggle}
          className='px-4 py-1 bg-blue-600 rounded-lg text-white'
        >
          {isEdit ? '완료' : '변경'}
        </button>
      </div>
      {isEdit ? (
        <Edit />
      ) : (
        <LookUp
          name={userData.name}
          phone={userData.phone}
          email={userData.email}
        />
      )}
    </div>
  );
};

export default MyPage;
