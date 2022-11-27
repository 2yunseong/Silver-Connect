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
    'http://133.186.219.125:8080/api/user/0',
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
        <Edit
          name={data.name}
          phone={data.phoneNumber}
          changeName={newName.onChange}
          changePhone={newPhone.onChange}
          changePassword={newPassword.onChange}
        />
      ) : (
        <LookUp name={data.name} phone={data.phone} email={data.email} />
      )}
    </div>
  );
};

export default MyPage;
