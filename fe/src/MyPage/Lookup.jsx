import React from 'react';

import profile from './profile.png';

const LookUp = ({ name, phone, email }) => {
  return (
    <div className='text-xl font-normal'>
      <img
        className='rounded-full w-60 mx-auto mt-10 mb-5'
        src={profile}
        alt='profile'
      />
      <div className='name-element flex pt-10 pb-2 border-b'>
        <div className='w-1/3'>이름</div>
        <div className='w-2/3'>{name}</div>
      </div>
      <div className='phone-element flex pt-10 pb-2 border-b'>
        <div className='w-1/3'>연락처</div>
        <div className='w-2/3'>{phone}</div>
      </div>
      <div className='email-element flex pt-10 pb-2 border-b'>
        <div className='w-1/3'>이메일</div>
        <div className='w-2/3'>{email}</div>
      </div>
    </div>
  );
};

export default LookUp;
