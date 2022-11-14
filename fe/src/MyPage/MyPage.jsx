import React, { useEffect, useState } from 'react';
import { myPageData } from '../util/dummy';
import LookUp from './Lookup';
import Edit from './Edit';

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
    <div className='my-page-container'>
      <header className='flex'>
        <h2>마이 페이지</h2>
        <button onClick={onToggle}>{isEdit ? '완료' : '변경'}</button>
      </header>
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
