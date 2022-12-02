import React, { useState } from 'react';
import LookUp from './Lookup';
import Edit from './Edit';
import './MyPage.css';
import useSWR from 'swr';
import fetcher from '../util/fetcher';
import useInput from '../Hooks/useInput';
import { useNavigate } from 'react-router-dom';

const MyPage = () => {
  const navigate = useNavigate();
  const [isEdit, setIsEdit] = useState(false);
  const newPassword = useInput();
  const newName = useInput();
  const newPhone = useInput();

  const { data, error } = useSWR(
    `http://133.186.219.125:8080/api/user?id=1`,
    fetcher
  );

  if (error) return <div>fail read</div>;
  if (!data) return <div>loading..</div>;

  const onToggle = () => {
    if (isEdit) {
      // edit logic => to server... send data
      navigate('/');
      alert('변경 완료!');

      return;
    }
    setIsEdit(() => !isEdit);
  };

  console.log(data);

  return (
    <div className='my-page-container flex justify-center items-center flex-col border rounded-lg py-10 shadow-lg'>
      <div className='flex justify-between py-5 px-12 w-full'>
        <h2 className='font-bold text-4xl'>내 정보</h2>
        <button
          onClick={onToggle}
          className='px-7 py-1 bg-blue-600 rounded-lg text-white'
        >
          {isEdit ? '완료' : '변경'}
        </button>
      </div>
      {isEdit ? (
        <Edit
          name={data.name}
          phone={data.phoneNumber}
          changeName={newName.onChange}
          changePhone={newPhone.onChange}
          changePassword={newPassword.onChange}
        />
      ) : (
        <LookUp name={data.name} phone={data.phoneNumber} email={data.email} />
      )}
    </div>
  );
};

export default MyPage;
