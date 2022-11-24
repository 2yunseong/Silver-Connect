import React from 'react';

import profile from './profile.png';

const LookUp = ({ name, phone, email }) => {
  return (
    <div className='text-2xl font-semibold'>
      <img
        className='rounded-full w-50 p-3 mx-auto mt-0 mb-10'
        src={profile}
        alt='profile'
      />
      <div className='name-element flex py-5'>
        <div className='w-1/3'>이름</div>
        <div className='w-2/3'>{name}</div>
      </div>
      <div className='phone-element flex py-5'>
        <div className='w-1/3'>연락처</div>
        <div className='w-2/3'>{phone}</div>
      </div>
      <div className='email-element flex py-5'>
        <div className='w-1/3'>이메일</div>
        <div className='w-2/3'>{email}</div>
      </div>
    </div>
  );
};

export default LookUp;
